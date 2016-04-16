// controleur de la page updateTournament
angular.module('TournamentOrganizerApp').controller('updateTournament',
    function ($scope,
              $routeParams,
              UserTournament,Tournament,User,Game) {
		$scope.cacherPremierFormUpdate = true;
			$scope.updatetournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				$scope.cacherPremierFormUpdate = false
				$scope.afficherSecondFormUpdate = true;
				// envoie au WS
				
         };
		 $scope.deletetournament = function(){		 
				var selectedTournament = $scope.selectedTournament;
				// envoie au WS
				
         };
		 
		 $scope.addMatchScoretournament = function(){
				//récupération des var du form
				var p1Match = $scope.match_1_p1_name;
				var p2Match = $scope.match_1_p2_name;
				var butP1 = $scope.match_1_score_p1;
				var butP2 = $scope.match_1_score_p2;
				alert(butP2);
				// envoie au WS
				
         };
         });
   