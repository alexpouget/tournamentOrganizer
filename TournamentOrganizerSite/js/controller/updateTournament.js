// controleur de la page updateTournament
angular.module('TournamentOrganizerApp').controller('updateTournament',
    function ($scope,
              $routeParams,$location,
              UserTournament,Tournament,User,Game,UserMatch) {
		$scope.selectedTournament = 0;
		$scope.tournaments = Tournament.query()
		$scope.tournament;
		$scope.games = Game.query()
		$scope.userMatchs = UserMatch.query()


		$scope.cacherPremierFormUpdate = true;

		$scope.updatetournament = function(){
			var selectedTournament = $scope.selectedTournament;
			$scope.cacherPremierFormUpdate = false
			$scope.afficherSecondFormUpdate = true;
			$scope.tournament = Tournament.get({Id:$scope.selectedTournament.id});

			for(var g in $scope.games){
				if($scope.games[g].idTournament!=null && $scope.games[g].idTournament.id==$scope.selectedTournament.id) {
					$scope.games[g].joueur = "";
					for (var i in $scope.userMatchs) {
						if ($scope.userMatchs[i].idGame != null) {

							if ($scope.userMatchs[i].idGame.id == $scope.games[g].id && $scope.games[g].joueur == "") {
								$scope.games[g].joueur = $scope.userMatchs[i];
							} else if ($scope.userMatchs[i].idGame.id == $scope.games[g].id) {
								$scope.games[g].joueur2 = $scope.userMatchs[i];
							}
						}
					}
				}

			}



         };

		$scope.filterGame = function(element) {
			if(element.idTournament.id==$scope.selectedTournament.id){
				return true;
			}
			return false;
		};

		 $scope.deletetournament = function(){
			 Tournament.delete({Id:$scope.selectedTournament.id})
			 $scope.tournaments = Tournament.query()
         };
		 
		 $scope.addMatchScoretournament = function(){

			 for(var g in $scope.games){
				 if($scope.games[g].idTournament!=null &&  $scope.games[g].idTournament.id==$scope.selectedTournament.id) {
					 var new_game = UserMatch.get({Id:$scope.games[g].joueur.id})
					 window.alert(angular.toJson(new_game))
					 new_game = $scope.games[g].joueur
					 new_game.$update({Id: new_game.id})
					 var new_game2 = UserMatch.get({Id:$scope.games[g].joueur2.id})
					 new_game2 = $scope.games[g].joueur2
					 new_game2.$update({Id: new_game2.id})

					 var new_ = new UserTournament()
					 new_.id = $scope.games[g].joueur.idUser.id
					 new_.idTournament = $scope.games[g].joueur.idUser.idTournament;
					 new_.idUserTournament = $scope.games[g].joueur.idUser.idUserTournament;
					 new_.points = $scope.games[g].joueur.idUser.points;
					 var new_2 = new UserTournament()
					 new_2.id = $scope.games[g].joueur2.idUser.id
					 new_2.idTournament = $scope.games[g].joueur2.idUser.idTournament;
					 new_2.idUserTournament = $scope.games[g].joueur2.idUser.idUserTournament;
					 new_2.points = $scope.games[g].joueur2.idUser.points;

					 if(new_game.score>new_game2.score){
						 new_.points += 3;
						 new_2.points += 0;
					 }else if(new_game.score<new_game2.score){
						 new_.points += 0;
						 new_2.points += 3;
					 }else{
						 new_.points += 1;
						 new_2.points += 1;
					 }
					 window.alert(angular.toJson(new_));
					 window.alert(angular.toJson(new_2));

					 new_.$update({Id:new_.id})
					 new_2.$update({Id:new_2.id})

					 $location.path("/showTournament/"+$scope.selectedTournament.id);
				 }
			 }
         };
         });
   