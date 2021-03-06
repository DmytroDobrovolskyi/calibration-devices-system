/**
 * Created by MAX on 30.07.2015.
 */
angular
    .module('employeeModule')
    .controller('UsersControllerCalibrator', ['$scope','UserServiceCalibrator','UserService', '$modal', '$log', 'ngTableParams', '$timeout', '$filter','$rootScope',
        function ($scope,UserServiceCalibrator,userService, $modal, $log, ngTableParams, $timeout, $filter, $rootScope) {
            $scope.totalEmployee=0;

            $scope.tableParams = new ngTableParams({
                page: 1,
                count: 5
            }, {
                total: 0,
                getData: function ($defer, params) {
                    UserServiceCalibrator.getPage(params.page(), params.count(), params.filter())
                        .success(function (result) {
                            $scope.totalEmployee=result.totalItems;
                            $defer.resolve(result.content);
                            params.total(result.totalItems);
                        }, function (result) {
                            $log.debug('error fetching data:', result);
                        });
                }
            });

            $scope.isFilter = function () {
                var obj = $scope.tableParams.filter();
                for (var i in obj) {
                    if (obj.hasOwnProperty(i) && obj[i]) {
                        return true;
                    }
                }
                return false;
            };

            $scope.showCapacity = function (username) {

                $modal.open({
                    animation: true,
                    templateUrl: '/resources/app/calibrator/views/employee/capacity-calibratorEmployee.html',
                    controller: 'CapacityEmployeeControllerCalibrator',
                    size: 'lg',
                    resolve: {

                        capacity: function () {
                            return UserServiceCalibrator.getCapacityOfWork(username)
                                .success(function (verifications) {
                                    return verifications;
                                });
                        }
                    }
                });
            };


            $scope.onTableHandling = function () {

                UserServiceCalibrator.isAdmin()
                    .success(function (response) {
                        var roles = response + '';
                        var role = roles.split(',');
                        var thereIsAdmin = 0;
                        for (var i = 0; i<role.length; i++){
                            if(role[i]==='PROVIDER_ADMIN') {
                                thereIsAdmin++;
                            }
                            if(role[i]==='CALIBRATOR_ADMIN') {
                                thereIsAdmin++;
                            }
                            if(role[i]==='STATE_VERIFICATOR_ADMIN') {
                                thereIsAdmin++;
                            }
                        }
                        if (thereIsAdmin > 0){
                            $scope.verificator = true;
                        }else{
                            $scope.accessLable = true;
                        }
                    });
            };


            $scope.openAddEmployeeModal = function() {
                var addEmployeeModal = $modal
                    .open({
                        animation : true,
                        controller : 'AddEmployeeController',
                        templateUrl : '/resources/app/provider/views/employee/employee-add-modal.html',
                    });
            };

            $scope.onTableHandling();

            $scope.openEditEmployeeModal = function(username) {
                userService.getUser(username)
                    .success(function(data){
                        $rootScope.user = data;
                        $rootScope.$broadcast("info_about_editUser", {roles : $rootScope.user.userRoles,
                                                                      isAvaliable: $rootScope.user.isAvaliable
                                                                        });
                    });
                var addEmployeeModal = $modal
                    .open({
                        animation : true,
                        controller : 'EditEmployeeController',
                        templateUrl : '/resources/app/provider/views/employee/employee-edit-modal.html',

                    });
            };


        }]);

