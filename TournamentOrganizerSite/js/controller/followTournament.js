/**
 * Created by alex on 17/04/2016.
 */
angular.module('TournamentOrganizerApp').controller('followTournament',
    function($scope,$location,
             Tournament,TypeTournament) {

        $scope.tournaments = Tournament.query()
        $scope.selectedTournament;

        $scope.followtournament = function () {
            $location.path("/showTournament/"+$scope.selectedTournament.id);
        }

    });