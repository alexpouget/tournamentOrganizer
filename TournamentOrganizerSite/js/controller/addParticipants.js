/**
 * Created by alex on 16/04/2016.
 */
angular.module('TournamentOrganizerApp').controller('addParticipants',
    function ($scope,
              $routeParams,
              UserTournament,Tournament,User,Game) {

        // recuperation des données du controller de createTournament

        id = $routeParams.id;

        $scope.tournamentData = Tournament.get({Id:id})
        $scope.hide=false;
        $scope.countClick = 0;


        $scope.ajouterPart = function() {
            var user = new User();
            user.name = $scope.player_name
            user.$save(function(nuser) {
                window.alert("new user");
                var usertournament = new UserTournament()
                usertournament.idTournament = $scope.tournamentData;
                usertournament.idUserTournament = nuser;
                usertournament.$save(function(data) {
                    if($scope.countClick == $scope.tournamentData.nbPlayer)
                    {
                        window.alert("Game");
                        var game = new Game()
                        game.idTournament = $scope.tournamentData;
                        game.$save(function(gamesave) {
                                window.alert("Ok");
                                $location.path("/followTournament");
                        });

                    }
                });
            });
            $scope.player_name = ""
            $scope.countClick++;
        }

    });
