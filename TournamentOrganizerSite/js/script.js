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
            controller: 'followTournament'
        })
		 .when('/updateTournament', {
            templateUrl: 'views/updateTournament.html',
            controller: 'updateTournament'
        })
		 .when('/showTournament', {
            templateUrl: 'views/showTournament.html',
            controller: 'showTournament'
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


// controleur de la page followTournament
TournamentOrganizerApp.controller('followTournament', ['$scope',
    function($scope){
			$scope.followtournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				// envoie au WS
         };
         }
    
]);

// controleur de la page updateTournament
TournamentOrganizerApp.controller('updateTournament', ['$scope',
    function($scope){
			$scope.followtournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				// envoie au WS
         };
         }
    
]);


// controleur de la page showTournament
TournamentOrganizerApp.controller('showTournament', ['$scope',
    function($scope){
	
		// pour l'instant mis en mode tournoi les affichage pour le mode championnat sont en display none 
		// Il faudra tester au moment du choix du tournoi si c'est un tournoi(coupe) ou un championnat et adapté l'affichage en fonction
		$scope.afficherResChamp=true;
		$scope.afficherBouttonClass=true;
		
		$scope.afficherResTour = function(){
				// recuperation du tournoi séléctionné
				var tourSelected = $scope.tourSelected;
				// On affiche le tableau des resultats tournoi
				$scope.afficherResTournoi= true;
         };
		 
		 $scope.AfficherClassement = function(){		
				// On affiche le classement
				$scope.afficherClass= true;
				// On cache le tableau des résultats
				$scope.afficherResChamp= false;
				// On cache le boutton Classement
				$scope.afficherBouttonClass= false;
				// On affiche le boutton retour aux résultats
				$scope.afficherBouttonBackToRes= true;
         };
		 
		 $scope.BackToRes = function(){		
				// On cache le tableau du classement
				$scope.afficherClass= false;
				// On réaffiche le tableau des resultats
				$scope.afficherResChamp= true;
				// On réaffiche le boutton classement
				$scope.afficherBouttonClass= true;
				// On cache le boutton retour aux resultats
				$scope.afficherBouttonBackToRes= false;
         };
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