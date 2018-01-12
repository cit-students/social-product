(function () {
    'use strict';

    var todoApp = angular.module('todoApp');
    todoApp.controller('LoginController', LoginController);
    LoginController.$inject = ['$scope'];
    function LoginController($scope) {
        $scope.gmail = {
            username: "",
            email: ""
        };
        $scope.facebook = {
            username: "",
            email: ""
        };
        $scope.onGoogleLogin = function () {
            var params = {
                'clientid': '248188326609-rrs87kujum46leqo54r7rh35dp1k60f0.apps.googleusercontent.com',
                'cookiepolicy': 'single_host_origin',
                'callback': function (result) {
                    if (result['status']['signed_in']) {
                        var request = gapi.client.plus.people.get(
                            {
                                'userId': 'me'
                            }
                        );
                        request.execute(function (resp) {
                            $scope.$apply(function () {
                                $scope.gmail.username = resp.displayName;
                                $scope.gmail.email = resp.emails[0].value;
                                $scope.g_image = resp.image.url;
                            });
                        });
                    }

                },
                'approvalprompt': 'force',
                'scope': 'https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.profile.emails.read'
            };
            gapi.auth.signIn(params);
        }
        $scope.onFBLogin = function () {
            FB.login(function (response) {
                if (response.authResponse) {
                    FB.api('/me', 'GET', {fields: 'email, first_name, name, id, picture'}, function (response) {
                        $scope.$apply(function () {
                            $scope.facebook.username = response.name;
                            $scope.facebook.email = response.email;
                            $scope.fb_image = response.picture.data.url;
                        });
                    });
                } else {
                    //error
                }
            }, {
                scope: 'email, user_likes',
                return_scopes: true
            });
        }

    }

})();