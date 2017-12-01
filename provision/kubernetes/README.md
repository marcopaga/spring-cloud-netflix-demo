# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start`.

## Deployment

`kubectl create -f deployment.yml`

`kubectl expose deployment cloud-deployment --type=NodePort`

`kubectl describe deployment cloud-deployment`

`kubectl get pods -l app=cloud-app`

`minikube service cloud-deployment`

`kubectl delete deployment cloud-deployment`

`kubectl delete service cloud-deployment`