const request = require('supertest')
const app = require('../index.js')

afterAll(done => {
  app.close();
  done();
});

describe('Get All', () => {
  it('should be 200', async () => {
    const res = await request(app)
      .get("/get")
    expect(200);
  })

  it('should send object', async () => {
    const res = await request(app)
      .get("/get")
    expect(res.body && typeof res.body === 'object').toBe(true);
  })

  it('should have empleados', async () => {
    const res = await request(app)
      .get("/get")
    expect(res.body).toHaveProperty('empleados');
  })

})
