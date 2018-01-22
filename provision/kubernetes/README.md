# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start` with the default of 2GB RAM and 2 CPUs.

To set a custom amount of RAM and CPU:

`minikube start --vm-driver virtualbox --memory 8192 --cpus 4`

## Deployment

```
kubectl create -f cloud.yml

kubectl describe deployment cloud-edgeservice-deployment

kubectl get pods -l app=cloud

kubectl logs -lapp=cloud,component=backend

minikube service cloud-backend-service

minikube service eureka-service

http $(minikube service edgeservice-service --url)/frontend/

minikube service zipkin-service

```

## Clearing

Clear the plate by using `kubectl delete pod,service,deployment -l app=cloud`