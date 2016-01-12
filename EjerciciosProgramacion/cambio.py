def detectarNumero():
	dinero = int(input('introduce la cantidad de dinero '))
	while dinero < 0 or :
		dinero = int(input('introduce la cantidad de dinero...POSITIVA Y ¡SOLO NUMEROS! '))




def devolverCambio(dinero):
	listaDinero = [500, 200, 100, 50, 20, 10, 5, 2, 1]
	for elemento in listaDinero:
		if (dinero / elemento) >= 1 and dinero >= 5:
			cantidadElemento = int(dinero / elemento)
			dinero = dinero - (elemento * cantidadElemento)
			print (str(cantidadElemento) + ' billete/s de ' + str(elemento))
		elif (dinero / elemento) >= 1 and dinero < 5:
			cantidadElemento = int(dinero / elemento)
			dinero = dinero - (elemento * cantidadElemento)
			print (str(cantidadElemento) + ' moneda/s de ' + str(elemento))
		else:
			pass

#programa principal#
dinero = detectarNumero()
devolverCambio(dinero)





#casos test#
#caso devolverCambio()#

def devolverCambio(dinero):
	listaDinero = [500, 200, 100, 50, 20, 10, 5, 2, 1]
	prueba=''
	for elemento in listaDinero:
		if (dinero / elemento) >= 1 and dinero >= 5:
			cantidadElemento = int(dinero / elemento)
			dinero = dinero - (elemento * cantidadElemento)
			prueba = prueba + (str(cantidadElemento) + ' ' + str(elemento) + ',')
		elif (dinero / elemento) >= 1 and dinero < 5:
			cantidadElemento = int(dinero / elemento)
			dinero = dinero - (elemento * cantidadElemento)
			prueba = prueba + (str(cantidadElemento) + ' ' + str(elemento) + ',')
		else:
			pass
	return prueba
test = ([123, '1 100,1 20,1 2,1 1,'],[100, '1 100,'], [-88, '-1 50, -1 20, -1 10, -1 5, -1 2, -1 1,'])
def testDevolverCambio(test):
	for subTest in test:
		print (subTest)
		pruebaFinal = devolverCambio(subTest[0])
		if pruebaFinal == subTest[1]:
			print('ok')
		else:
			print('fail')