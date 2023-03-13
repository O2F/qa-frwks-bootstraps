describe('Api simple test', () => {
    let tokenCollector;
    before(() => {
        //this is just a dummy fetch, it doesn't need to be used and it is not used anywhere
        cy.request({
            method: 'POST',
            body: {"email": "eve.holt@reqres.in", "password": "cityslicka"},
            url: '/login',
            failOnStatusCode: false
        }).then(({body}) =>{
            expect(body.token).to.not.equal("")
            //without using cy.wrap(body.token).as("token")
            tokenCollector = body.token

            //using cy.wrap(body.token).as("token")
            cy.wrap(body.token).as("token")

        })  

    });

    it('simple GET test with status 200', () => {
        //without using cy.wrap(body.token).as("token") from the before method
        cy.log(tokenCollector)

        //using cy.wrap(body.token).as("token") from the before method

        cy.get("@token").then((token) => {
            cy.log(token)
        })

        cy.request({
            method: 'GET',
            url: '/users?page=2',
            failOnStatusCode: false
        }).then((response) =>{
            expect(response.status).to.equal(200)
            expect(response.body).to.not.be.equal("")

        })
    }),
    
    it('simple POST test', () => {
        cy.request({
            method: 'POST',
            body: {"email": "eve.holt@reqres.in", "password": "cityslicka"},
            url: '/login',
            failOnStatusCode: false
        }).then((response) =>{
            cy.log(response.body)
            expect(response.status).to.equal(200)
            expect(response.body.token).to.equal("QpwL5tke4Pnpja7X4")
        })
    }),

    it('Multiple chained requests', () => {
        cy.request({
            method: 'POST',
            body: {
                "name": "morpheus",
                "job": "leader"
            },
            url: '/users',
            failOnStatusCode: false
        }).then((firstResponse) =>{
            expect(firstResponse.status).to.equal(201)
            return firstResponse.body.id
        }).then((id)=>{
            const uri = `/users/${id}`
            cy.request({
                method: 'DELETE',
                url: uri,
                failOnStatusCode: false
            }).then((secondResponse) => {
                expect(secondResponse.status).to.equal(204)
            })
        })
    }),

    it('Simple POST test with error status', () => {
        cy.request({
            method: 'POST',
            body: {},
            url: '/login',
            failOnStatusCode: false
        }).then((response) => {
            expect(response.status).to.equal(400)
            expect(response.body.error).to.equal('Missing email or username')
        })
    })
})