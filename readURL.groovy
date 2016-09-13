@Grab("org.codehaus.groovy.modules.http-builder:http-builder:0.7")
import groovyx.net.http.RESTClient

RESTClient client = new RESTClient("http://49.156.19.60:8080/beethoven/")
def response = client.get(path: "products/holistic-dog-lamb-cans")

def responseDate = response.getData()

def CatCount = 0; 
def DogCount = 0; 

println("")
println("status")
println(responseDate.status)

def dataPart = responseDate.data
println("")
println("data part ")
println(dataPart)

def categoriesPart = dataPart.categories; 
println("")
println("categories:")
println(categoriesPart)

for(i in 0 .. categoriesPart.size()-1) {
	println("")
	println("categoriesPart " + i)
	println categoriesPart.get(i)

	def tagsPart = categoriesPart.get(i).tags
	println("")
	println("tagsPart:")
	println(tagsPart)
	
	def idPart = categoriesPart.get(i).id
	println("")
	println("idPart:")
	println(idPart)
	
	if (idPart == 'Pet') {
		println("")
		println("Pet found!")
		for(j in 0 .. tagsPart.size()-1) {
			def petPart = tagsPart.get(j)
			if (petPart == 'Dog') {
				println("")
				println("Dog found!")
				DogCount = DogCount + 1; 
			}
			if (petPart == 'Cat') {
				println("")
				println("Cat found!")
				CatCount = CatCount + 1; 
			}
		}
	}	
}

println("Dog found: " + DogCount)
println("Cat found: " + CatCount)




