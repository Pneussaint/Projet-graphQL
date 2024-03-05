const { request, gql } = require('graphql-request');

/*
const query = gql`
  {
    recentPosts(count: 5, offset: 0){
        id
        title
    }
  }
`;
*/
 
const query = `
    {
        recentPosts(count: 5, offset: 0){
            id
            title
        }
    }
`;

request('http://localhost:8080/graphql', query)
    .then(
        (data) => {
            data.recentPosts.forEach(element => {
              console.log(`Found Post #${element.id} with title ${element.title} !`);  
            });
        });

