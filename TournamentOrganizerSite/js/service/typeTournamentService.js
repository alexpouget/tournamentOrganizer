/**
 * Created by alex on 16/04/2016.
 */

angular.module('TournamentOrganizerApp')
    .factory('TypeTournament', ['$resource',
        function($resource){
            return $resource('http:127.0.0.1:8080/typeTournament/:Id', {Id:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);