incioBusqueda = 0
finalEnlace = 0
codigoHtml = 'oghkjadfkldsfgjñldfkhjdkñlfh <a href="guay">kljgknllkkdsjfghñlkdjfhñldkjh <a href "masguay"> dsafhdshjjdfj'
posicionEnlace = web.find('<a href="', incioBusqueda)
inicioUrl = web.find('"', posicionEnlace)+1
finalUrl=web.find('"', incioUrl)
url=web[inicioUrl:finalUrl]
inicioBusqueda=finalUrl
urls= urls
eso nada
urls=' '
urls=urls+url
corrijo
urls = urls + ',' + url





from urllib.request import urlopen
def get_page_3(url):
	pagina = urlopen(url)
	codigoHtml = pagina.read().decoder('utf')
	pagina.close()
	return codigoHtml





def buscarUrl (codigoHtml):
	inicioBusqueda = 0
	while codigoHtml.find('<a href="', inicioBusqueda) != -1:
		posicionEnlace = codigoHtml.find('<a href="', inicioBusqueda)
		inicioUrl = codigoHtml.find('"', posicionEnlace)+1
		finalUrl=codigoHtml.find('"', inicioUrl)
		url=codigoHtml[inicioUrl:finalUrl]
		inicioBusqueda = finalUrl
		print(url)



#caso test#

codigoHtml = 'oghkjadfkldsfgjñldfkhjdkñlfh <a href="guay">kljgknllkkdsjfghñlkdjfhñldkjh <a href="masguay"> dsafhdshjjdfj'













