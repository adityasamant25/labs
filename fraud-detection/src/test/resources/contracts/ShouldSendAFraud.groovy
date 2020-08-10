import org.springframework.cloud.contract.spec.Contract

Contract.make {
	label("trigger_fraud")
	input {
		triggeredBy("trigger()")
	}
	outputMessage {
		sentTo("fraud")
		body([surname: "m"])
		headers{
			messagingContentType(applicationJson())
		}
	}
}