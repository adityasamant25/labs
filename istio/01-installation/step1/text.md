
Download Istio as specified in the [Installation Steps](https://istio.io/latest/docs/setup/getting-started/#download)

```shell
curl -L https://istio.io/downloadIstio | sh -
```

Move to the Istio package directory. For example, if the package is istio-1.21.0:

```shell
cd istio-1.21.0
```

Add the `istioctl` client to your path:

```shell
export PATH=$PWD/bin:$PATH
```