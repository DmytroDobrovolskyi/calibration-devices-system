angular
    .module('employeeModule')
    .factory('VerificationServiceVerificator', ['$http', '$log', function ($http, $log) {

        return {
        	getArchiveVerifications: function (currentPage, itemsPerPage, search) {
            	return getDataWithParams('verificator/verifications/archive/' + currentPage + '/' + itemsPerPage, search);
            },
            getNewVerifications: function (currentPage, itemsPerPage, search) {
                return getDataWithParams('verificator/verifications/new/' + currentPage + '/' + itemsPerPage, search);
            },
            getNewVerificationDetails: function (verificationId) {
                return getData('verifications/new/' + verificationId);
            },
            getArchivalVerificationDetails: function (verificationId) {
                return getData('verifications/archive/' + verificationId);
            },
            getProviders: function (url) {
                return getData('verifications/new/providers');
            },
            sendVerificationsToProvider: function (data) {
                return updateData('new/update', data);
            },
            sendVerificationNotOkStatus: function (data) {
                return updateData('new/notOk', data);
            },
            sendInitiatedVerification:function(form){
                return sendData("send",form);
            },
            getVerificatorsCorrespondingProvider:function(url){ // ??
                return getData("applications/verificators");
            },
            getLocalitiesCorrespondingProvider:function(url){
                return getData("applications/localities");
            },
            getStreetsCorrespondingLocality:function(selectedLocality){
                return getData("applications/streets/" + selectedLocality.id);
            },
            getBuildingsCorrespondingStreet:function(selectedBuilding){
                    return getData("applications/buildings/" + selectedBuilding.id);
                },
            getCountOfNewVerifications: function(url) {
            	return getData('verifications/new/count/verificator');
            },
            markVerificationAsRead : function(data) {
            	return updateData('new/read', data);
            },
            searchNewVerifications : function(data) {
            	return sendDataWithParams('new/search', data);
            },
            getCalibraionTestDetails: function (verificationId){
            	return getData('verifications/show/' + verificationId);
            },
            
        };
       
        function getData(url) {

            $log.info(url);

            return $http.get('verificator/' + url)
                .success(function (data) {
                    return data;
                })
                .error(function (err) {
                    return err;
                });
        }
        
        function getDataWithParams(url, params) {
            return $http.get(url, {
                params : params
            }).success(function (data) {
                return data;
            }).error(function (err) {
                return err;
            });
        }

        function getDataWithParams(url, params) {
            return $http.get(url, {
                params : params
            }).success(function (data) {
                return data;
            }).error(function (err) {
                return err;
            });
        }

        function updateData(url, data) {
            return $http.put('verificator/verifications/' + url, data)
                .success(function (responseData) {
                    return responseData;
                })
                .error(function (err) {
                    return err;
                });
        }

        function sendData(url, data) {
            return $http.post('verificator/applications/' + url, data)
                .success(function (responseData) {
                    return responseData;
                })
                .error(function (err) {
                    return err;
                });
        }
    }]);
