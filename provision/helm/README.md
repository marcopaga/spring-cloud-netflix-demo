# Setup

Install helm.sh on your local machine. Make sure you are connected to a kubernetes cluster. If you want to set one up have a look at the plain [Kubernetes](../kubernetes) deployment info.

```
helm init 
```

#  Install the app

```
helm install --name test .
sleep 120 # or more ;)
http http://$(minikube ip)/frontend/
```

# Upgrade and apply in the cluster

```
helm upgrade test .
```

# Delete the app

```
helm delete test --purge
```