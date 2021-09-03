# feed-generator
feed-generator

## Available online to test
https://feedgenerator-solvians.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/feed-controller/getCertificatesList

## Curl Intput
```console
curl -X 'GET' \
  'https://feedgenerator-solvians.herokuapp.com/certificates/2/4' \
  -H 'accept: */*'
```

## Output
```console
pool-1-thread-1 :: Certificates{timestamp=2021-09-03 23:00:56.51, isin='HF077606844', BidPrice=9662.87, BidSize=1000, askPrice=9664.48, askSize=1000}
pool-1-thread-2 :: Certificates{timestamp=2021-09-03 23:00:56.512, isin='IC106338936', BidPrice=9665.29, BidSize=1000, askPrice=9678.19, askSize=1000}
pool-1-thread-1 :: Certificates{timestamp=2021-09-03 23:00:57.527, isin='HC395027517', BidPrice=3177.42, BidSize=1000, askPrice=3177.42, askSize=1000}
pool-1-thread-2 :: Certificates{timestamp=2021-09-03 23:00:57.53, isin='IC051659206', BidPrice=3174.2, BidSize=1000, askPrice=3174.2, askSize=1000}
```

![alt text](https://raw.githubusercontent.com/imdadareeph/feed-generator/main/screenshots/1.png "preview1")
![alt text](https://raw.githubusercontent.com/imdadareeph/feed-generator/main/screenshots/2.png "preview2")