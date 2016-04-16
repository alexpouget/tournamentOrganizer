/**
 * Created by alex on 16/04/2016.
 */

angular.module('TournamentOrganizerApp')
    .factory('User', ['$resource',
        function($resource){
            return $resource('http:127.0.0.1:8080/user/:userId', {userId:'@id'},
                {
                    'update': {method: 'PUT'}
                }
            );
        }
    ]);