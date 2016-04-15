'use strict';


/**
 * Déclaration de l'application TournamentOrganizerApp
 */
var TournamentOrganizerApp = angular.module('TournamentOrganizerApp', [
    // Dépendances du "module"
    'ngRoute',
	'routeAppControllers'
]);


/**
 * Configuration du module principal : routeApp
 */
 
TournamentOrganizerApp.config(['$routeProvider',
    function($routeProvider) { 
        
        // Système de routage
        $routeProvider
        .when('/index', {
            templateUrl: 'bb.html',
            controller: 'homeCtrl'
        })
        .when('/createTournament', {
            templateUrl: 'views/createTournament.html',
            controller: 'createTournament'
        })
		 .when('/addParticipants/?', {
            templateUrl: 'views/addParticipants.html',
            controller: 'addParticipants'
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
            redirectTo: '/breh'
        });
    }
]);

/**
 * Définition des contrôleurs
 */
var routeAppControllers = angular.module('routeAppControllers', []);


// Contrôleur de la page CreateTournament
routeAppControllers.controller('createTournament', ['$scope','dataShare',
    function($scope,dataShare){
		 $scope.send = function(){		 
           dataShare.sendData($scope);
         };
    }
]);


// Contrôleur de la page d'accueil
routeAppControllers.controller('homeCtrl', ['$scope',
    function($scope){
        $scope.message = "Bienvenue sur la page d'accueil";
    }
]);


// Contrôleur de la page addParticipants
routeAppControllers.controller('addParticipants', ['$scope','dataShare',
    function ($scope,dataShare) {         
               
			   // recuperation des données du controller de createTournament
               var text =  dataShare.getData(); 
			   $scope.hide=false;
			   var countClick = 0;
			   
			   // recuperation des valeurs du précédent form
			   var nb_part = text.nb_part;
			   var jeu = text.jeu;
			   var tournamentType = text.tournamentType;
			   var participants = [];
			   var params = { "nb_part" : nb_part, "jeu" : jeu, "tournamentType": tournamentType, "participants" : participants };
			  $scope.ajouterPart = function() {
			  participants.push($scope.player_name);
					countClick++;
				if(countClick == nb_part)
				{
					$scope.hide= true;
				}
		}
		
		$scope.createTournamentCall = function() {
		// transmettre les données au WS
		alert('on envoie');
		}
		}
]);

// controleur de la page followTournament
routeAppControllers.controller('followTournament', ['$scope',
    function($scope){
			$scope.followtournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				// envoie au WS
         };
         }
    
]);

// controleur de la page updateTournament
routeAppControllers.controller('updateTournament', ['$scope',
    function($scope){
			$scope.followtournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				// envoie au WS
         };
         }
    
]);

// controleur de la page showTournament
routeAppControllers.controller('showTournament', ['$scope',
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