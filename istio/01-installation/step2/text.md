
Install Istio using the `demo` profile

`istioctl install --set profile=demo -y`

Add a namespace label to instruct Istio to automatically inject Envoy sidecar proxies to application's in the `default` namespace:

`kubectl label namespace default istio-injection=enabled`