/**
 * Created by alex on 17/04/2016.
 */
angular.module('TournamentOrganizerApp').controller('showTournament',
    function($scope,$location,$routeParams,
             Tournament,TypeTournament,UserTournament) {

        var id = $routeParams.id;
        $scope.tournament = Tournament.get({Id:id});
        $scope.userTournaments = UserTournament.query();

        $scope.filterFunction = function(element) {
            if(element.idTournament.id==id){
                return true;
            }
            return false;
        };


    });