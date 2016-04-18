/**
 * Created by alex on 16/04/2016.
 */
angular.module('TournamentOrganizerApp').controller('addParticipants',
    function ($scope,$location,$routeParams,
              UserTournament,Tournament,User,Game) {

        id = $routeParams.id;

        $scope.tournamentData = Tournament.get({Id:id})
        $scope.hide=false;
        $scope.countClick = 0;


        $scope.ajouterPart = function() {
            var user = new User();
            user.name = $scope.player_name
            user.$save(function(nuser) {
                var usertournament = new UserTournament()
                usertournament.idTournament = $scope.tournamentData;
                usertournament.idUserTournament = nuser;
                usertournament.$save(function(data) {
                    if($scope.countClick == $scope.tournamentData.nbPlayer)
                    {
                        var game = new Game()
                        game.idTournament = $scope.tournamentData;
                        game.$save(function(gamesave) {
                                $location.path("/showTournament/"+id);
                        });

                    }
                });
            });
            $scope.player_name = ""
            $scope.countClick++;
        }

    });
