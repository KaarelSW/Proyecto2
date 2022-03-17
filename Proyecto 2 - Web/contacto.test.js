const { testEmail, testName, testNumber, testMensaje } = require('./contacto')

describe('Test Email', () => {
  it('should warn about introducing an email', () => {
    var value = testEmail("");
    expect(value).toBe("¡Introduce un e-mail!");
  })

  it('should warn about introducing a valid email', () => {
    expect(testEmail("blabla32")).toBe("Por favor, introduce un e-mail válido");
  })

  it('should warn about the name being too short', () => {
    var value = testEmail("42");
    expect(value).toBe("El e-mail no puede tener menos de 3 caracteres");
  })

  it('should warn about the name being too long', () => {
    var value = testEmail("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaassssssssssssssssssssssssssssssssssssssssssaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    expect(value).toBe("El e-mail no puede tener más de 254 caracteres");
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

  it('should warn about the name being too short', () => {
    var value = testName("Al");
    expect(value).toBe("El nombre no puede tener menos de 3 caracteres");
  })

  it('should warn about the name being too long', () => {
    var value = testName("Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Ruiz y Picasso");
    expect(value).toBe("El nombre no puede tener más de 50 caracteres");
  })

  it('should not give a warning', () => {
    expect(testName("Miguel Ángel")).toBe("");
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

  it('should warn about the phone number being too short', () => {
    var value = testNumber("42");
    expect(value).toBe("El número no puede tener menos de 3 caracteres");
  })

  it('should warn about the message being too long', () => {
    var value = testNumber("4201369133780082");
    expect(value).toBe("El número no puede tener más de 15 caracteres");
  })

  it('should not give a warning', () => {
    expect(testNumber("956884726")).toBe("");
  })

})

describe('Test Mensaje', () => {
  it('should warn about introducing a message', () => {
    var value = testMensaje("");
    expect(value).toBe("¡Introduce un mensaje!");
  })

  it('should warn about the message being too short', () => {
    var value = testMensaje("Hi");
    expect(value).toBe("El mensaje no puede tener menos de 3 caracteres");
  })

  it('should warn about the message being too long', () => {
    var value = testMensaje("Este es un mensaje escrito a mano (por mí mismo, nada menos) que tiene al menos trescientos caracteres para poder comprobar que, efectivamente, el método está haciendo su trabajo y detecta la longitud superior a lo permitido y da un mensaje de advertencia al respecto, impidiendo que el mensaje sea enviado.");
    expect(value).toBe("El mensaje no puede tener más de 300 caracteres");
  })

  it('should not give a warning', () => {
    expect(testMensaje("Mensaje completamente válido y normal")).toBe("");
  })
})
