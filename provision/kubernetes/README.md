# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start`.

## Deployment

```
kubectl create -f deployment.yml

kubectl expose deployment cloud-deployment --type=NodePort

kubectl describe deployment cloud-deployment

kubectl get pods -l app=demo

kubectl logs -lapp=demo

minikube service cloud-deployment

curl $(minikube service cloud-deployment --url)/add/23/42/

kubectl delete deployment cloud-deployment

kubectl delete service cloud-deployment
```

## Kompose

[http://kompose.io/](Kompose) is a simple tool to convert Docker compose file to the equivalent kubernetes descriptors.
This seems to be nice for a first start but - as expected - needs manual tweaking.