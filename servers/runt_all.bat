start cmd /k java -jar syncwebserver.jar -p 8081
start cmd /k java -jar search-provider-with-pooling.jar server conf/imbd-search-node1.yaml
start cmd /k java -jar search-provider-with-callback.jar --server.port=8083