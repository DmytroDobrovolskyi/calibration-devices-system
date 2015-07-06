(function () {
    angular.module('verificatorModule', ['spring-security-csrf-token-interceptor',
        'ui.bootstrap', 'ui.router', 'ui.bootstrap.showErrors'])

        .config(['$stateProvider', '$urlRouterProvider', 'showErrorsConfigProvider',

            function ($stateProvider, $urlRouterProvider, showErrorsConfigProvider) {

                showErrorsConfigProvider.showSuccess(true);

                $urlRouterProvider.otherwise('/');

                $stateProvider
                    .state('main-panel', {
                        url: '/',
                        templateUrl: '/resources/app/verificator/views/main-panel.html'
                    })
                    .state("new-verifications", {
                        url: '/verifications/new',
                        templateUrl: '/resources/app/verificator/views/new-verifications.html',
                        controller: 'NewVerificationsController'
                    })
//                    .state("calibration-test", {
//                        url: '/verifications/calibration-test',
//                        templateUrl: '/resources/app/calibrator/views/calibration-test-panel.html',
//                        controller: 'CalibrationTestController'
//                    })
                    .state("employees", {
                        url: '/employees',
                        templateUrl: '/resources/app/verificator/views/employee/main-panel.html',
                        controller: 'EmployeeController'
                    })
                    .state("verifications-archive", {
                        url: '/verifications/archive',
                        templateUrl: '/resources/app/verificator/views/archival-verifications.html',
                        controller: 'ArchivalVerificationsController'
                    });

//BEFORE MERGE!!!!!!!!!!!!!!!!!!!!!!!!!
            }]);

    angular.module('verificatorModule').run(function (paginationConfig) {
        paginationConfig.firstText = 'Перша';
        paginationConfig.previousText = 'Попередня';
        paginationConfig.nextText = 'Наступна';
        paginationConfig.lastText = 'Остання';
    });

    define([
        'controllers/TopNavBarController',
        'controllers/MainPanelController',
        'controllers/NewVerificationsController',
        'controllers/DetailsModalController',
        'controllers/SendingModalController',
       // 'controllers/CalibrationTestController',
        'controllers/EmployeeController',
        'controllers/AddressModalController',
       // 'services/CalibrationTestService',
        'services/AddressService',
        'services/UserService',
        'services/VerificationService'
    ], function () {});
})();