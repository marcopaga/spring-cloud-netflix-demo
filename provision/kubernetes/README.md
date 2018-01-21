# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start`.

To set a custom amount of RAM and CPU:

`minikube start --vm-driver virtualbox --memory 8192 --cpus 4`

The default is 2GB of RAM and 2 CPUs.

## Deployment

```
kubectl create -f cloud.yml

kubectl describe deployment cloud-backend

kubectl get pods -l app=cloud

kubectl logs -lapp=cloud

minikube service cloud-backend-service

curl $(minikube service cloud-backend-service --url)/add/23/42/

kubectl delete service cloud-backend-service

kubectl delete deployment cloud-backend-deployment
```