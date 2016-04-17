'use strict';


/**
 * Déclaration de l'application TournamentOrganizerApp
 */
var TournamentOrganizerApp = angular.module('TournamentOrganizerApp', [
    // Dépendances du "module"
    'ngRoute','ngResource'

]);


/**
 * Configuration du module principal : routeApp
 */
 
TournamentOrganizerApp.config(['$routeProvider',
    function($routeProvider) { 
        
        // Système de routage
        $routeProvider
		   .when('/accueil', {
				templateUrl: 'views/accueil.html',
				controller: 'homeCtrl'
			})
            .when('/createTournament', {
                templateUrl: 'views/createTournament.html',

            })
		 .when('/addParticipants/:id', {
            templateUrl: 'views/addParticipants.html'
        })
		 .when('/followTournament', {
            templateUrl: 'views/followTournament.html',
        })
		 .when('/updateTournament', {
            templateUrl: 'views/updateTournament.html',
        })
		 .when('/showTournament/:id', {
            templateUrl: 'views/showTournament.html',
        })
		 .otherwise({
             templateUrl: 'views/accueil.html',
             controller: 'homeCtrl'
        });
    }
]);

// Contrôleur de la page d'accueil
TournamentOrganizerApp.controller('homeCtrl', ['$scope',
    function($scope){
        $scope.message = "Bienvenue sur la page d'accueil";
    }
]);

// Fonction permettant l'échande de données entre deux controlleurs
TournamentOrganizerApp.factory('dataShare',function($rootScope){
  var service = {};
  service.data = false;
  service.sendData = function(data){
      this.data = data;
      $rootScope.$broadcast('data_shared');
  };
  service.getData = function(){
    return this.data;
  };
  return service;
});