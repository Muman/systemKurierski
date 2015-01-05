/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var CourierController = function ($scope, $http) {

//    $scope.editMode = false;
//    $scope.position = '';

    $scope.getAllCouriers = function () {
//        $scope.resetError();
//        $http.get('courier/all.json').success(function (response) {
//            $scope.couriers = response;
//        }).error(function () {
//            $scope.setError('Could not display all couriers');
//        });

        $scope.phones = [
            {'name': 'Nexus S',
                'snippet': 'Fast just got faster with Nexus S.'},
            {'name': 'Motorola XOOM™ with Wi-Fi',
                'snippet': 'The Next, Next Generation tablet.'},
            {'name': 'MOTOROLA XOOM™',
                'snippet': 'The Next, Next Generation tablet.'}
        ];
    };

    $scope.getAllCouriers();
};