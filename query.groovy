@Grab("org.codehaus.groovy.modules.http-builder:http-builder:0.7")
import groovy.json.JsonOutput 
import groovy.json.JsonSlurper 
import groovyx.net.http.RESTClient

RESTClient client = new RESTClient("http://49.156.19.60:8080/beethoven/")
def response = client.get(path: "products", query: ["query": "bird seed"])

def responseDate = response.getData()

println(responseDate.status)

def dataPart = responseDate.data

println(dataPart)

def productsPart = dataPart.products; 

println(productsPart)
