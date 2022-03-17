const {testEmail, testName, testNumber } = require('./contacto')

describe('Test Email', () => {
  it('should warn about introducing an email', () => {
    var value = testEmail("");
    expect(value).toBe("¡Introduce un e-mail!");
  })

  it('should warn about introducing a valid email', () => {
    expect(testEmail("blabla32")).toBe("Por favor, introduce un e-mail válido");
  })

  it('should not give a warning', () => {
    expect(testEmail("blabla32@gmail.com")).toBe("");
  })

})

describe('Test Name', () => {
  it('should warn about introducing a name', () => {
    var value = testName("");
    expect(value).toBe("¡Introduce un nombre!");
  })

  it('should warn about introducing a valid name', () => {
    expect(testName("blabla32")).toBe("Por favor, introduce un nombre válido");
  })

  it('should not give a warning', () => {
    expect(testName("Miguel Angel")).toBe("");
  })

})

describe('Test Number', () => {
  it('should warn about introducing a phone number', () => {
    var value = testNumber("");
    expect(value).toBe("¡Introduce un número de teléfono!");
  })

  it('should warn about introducing a valid phone number', () => {
    expect(testNumber("blabla32")).toBe("Por favor, introduce un número válido");
  })

  it('should warn about introducing a phone number without blanks', () => {
      expect(testNumber("956 884 726")).toBe("Por favor, introduce un número sin espacios");
    })

  it('should not give a warning', () => {
    expect(testNumber("956884726")).toBe("");
  })

})
