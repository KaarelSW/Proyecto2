const request = require('supertest')
const app = require('../index.js')

afterAll(done => {
  app.close();
  done();
});

describe('Get All', () => {
  it('should send json', async () => {
    const res = await request(app)
      .get("/get")
    expect(200)
    expect(res.body && typeof res.body === 'object').toBe(true)
    expect(res.body).toHaveProperty('empleados');
  })
})
