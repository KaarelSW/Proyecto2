const request = require('supertest')
const app = require('../index.js')

afterAll(done => {
  app.close();
  done();
});

describe('Get Empleado', () => {
  it('should be 200', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(200);
  })
  
  it('should be 404', async () => {
    const res = await request(app)
      .get("/empleado/willyrexgaymer")
    expect(404);
  })

  it('should send object', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body && typeof res.body === 'object').toBe(true);
  })

  it('should have nombre', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('nombre');
  })

  it('nombre shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.nombre).not.toEqual('');
  })

  it('nombre shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.nombre).not.toBeNull();
  })

  it('should have apellido', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('apellido');
  })  

  it('apellido shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.apellido).not.toEqual('');
  })

  it('apellido shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.apellido).not.toBeNull();
  })

  it('should have correo', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('correo');
  })

  it('correo shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.correo).not.toEqual('');
  })

  it('correo shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.correo).not.toBeNull();
  })

  it('should have usuario', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('usuario');
  })

  it('usuario shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.usuario).not.toEqual('');
  })

  it('correo shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.correo).not.toBeNull();
  })

  it('should have direccion', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('direccion');
  })

  it('direccion shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
      expect(res.body.direccion).not.toEqual('');
  })

  it('direccion shouldnt be a number', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.direccion).toBeNaN;
  })

  it('direccion shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.direccion).not.toBeNull();
  })

  it('should have contraseña', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body).toHaveProperty('contraseña');
  })

  it('contraseña shouldnt be empty', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.contraseña).not.toEqual('');
  })

  it('contraseña shouldnt be null', async () => {
    const res = await request(app)
      .get("/empleado/monteroa2")
    expect(res.body.contraseña).not.toBeNull();
  })

})
