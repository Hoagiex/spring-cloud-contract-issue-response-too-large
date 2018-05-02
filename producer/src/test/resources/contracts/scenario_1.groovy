package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("""
    TODO
    """)
    request {
        method 'GET'
        url value('/api/whocares')
    }
    response {
        status 200
        body value(
                consumer(file('scenario_1_response.json')),
//                producer(file('scenario_1_response.json'))) // ENABLED: CODE TOO LARGE ERROR
                producer("{\"message\": \"Hello\"}")) // ENABLED: generated stub takes 10 seconds to respond
        headers {
            contentType applicationJson()
        }
    }
}
