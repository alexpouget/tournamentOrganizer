/**
 * Created by alex on 16/04/2016.
 */
// Contrôleur de la page CreateTournament
angular.module('TournamentOrganizerApp').controller('createTournament',
        function($scope,$location,
            //,dataShare
                 Tournament,TypeTournament) {
    $scope.users = {};
    $scope.typeTournaments = {};
    $scope.tournamentType = {};
    $scope.nb_part = 0;
    $scope.nameTournament = "";

    $scope.send = function(){

        var t = new Tournament();
        t.name = $scope.nameTournament;
        t.nbPlayer = $scope.nb_part;
        var c = new TypeTournament();
        c.name = $scope.tournamentType.name;
        c.idTypeTournament = $scope.tournamentType.idTypeTournament;
        t.typeTournament = c;
        t.$save(function(data) {
            window.alert(angular.toJson(data))
            $location.path("/addParticipants/"+data.id);
        });
    }
    $scope.typeTournaments = TypeTournament.query()

});