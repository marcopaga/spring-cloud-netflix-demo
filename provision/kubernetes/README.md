# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start`.

## Deployment

```
kubectl create -f cloud-backend-deployment.yml

kubectl create -f cloud-backend-service.yml

kubectl describe deployment cloud-backend-deployment

kubectl get pods -l app=demo

kubectl logs -lapp=demo

minikube service cloud-backend

curl $(minikube service cloud-deployment --url)/add/23/42/

kubectl delete service cloud-backend

kubectl delete deployment cloud-backend-deployment
```

## Kompose

[http://kompose.io/](Kompose) is a simple tool to convert Docker compose file to the equivalent kubernetes descriptors.
This seems to be nice for a first start but - as expected - needs manual tweaking.