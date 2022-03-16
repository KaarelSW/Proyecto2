const request = require('supertest')
const app = require('../index.js')
describe('Get All', () => {
  it('should send json', () => {
    return request(app)
      .get("/get")
      .expect(200);
    //expect(res.body).toHaveProperty('post')
  })
})

afterAll(done => {
  done()
})