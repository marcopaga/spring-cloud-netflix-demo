# Kubernetes Deployment using minikube

## Minikube

Minikube is a simple eay to create a local kubernetes environment for development or testing.
Follow the installation instructions on [minikube/minikube](https://github.com/kubernetes/minikube). For macOS it is `brew install minikube`.
You can start minikube with `minikube start` with the default of 2GB RAM and 2 CPUs.

To set a custom amount of RAM and CPU:

```
minikube config set memory 12288
minikube config set cpus 4
minikube config set disk-size 20GB
minikube start
minikube addons enable ingress
```


## Google Cloud Platform Kubernetes Engine

You can sign up for a free account of the [GKE|https://cloud.google.com/kubernetes-engine/] at Google. You can provision clusters from the web frontend or the command line using the Google cloud SDK.

You can easily install the google cloud sdk using [brew cask|https://caskroom.github.io/].

`brew cask install google-cloud-sdk`

After the installation you can login the command line tools using this command. It will redirect you to an oauth endpoint at google where you can login.

`gcloud auth login`

### Create a cluster

You can create a cluster using the web ui or the command line. Please follow the [documentation|https://cloud.google.com/kubernetes-engine/docs/how-to/creating-a-container-cluster]. Please verify that you have matching versions of the kubectl client and server available.

After you create a cluster named _cluster-1_ you can connect your command line to the service. Check the cluster via the web ui to find the gcloud command on how to connect to your new cluster.

Your command line will look like this:

`gcloud container clusters get-credentials cluster-1 --zone us-central1-a --project cloud-demo-192820`

Verify that you are connected:

`kubectl config current-context`

Now you are ready to go.

## Deployment

```
kubectl create -f cloud.yml

kubectl describe deployment cloud-edgeservice-deployment

kubectl get pods -l app=cloud

kubectl logs -lapp=cloud,component=backend

minikube service eureka-service

https://192.168.99.100/frontend/

http $(minikube service edgeservice-service --url)/frontend/ X-B3-Flags:1

minikube service zipkin-service

```

## Clearing

Clear the plate by using `kubectl delete pod,service,deployment,ingress -l app=cloud`


### Stop the cluster

If you are on GKE please don't forget to stop the cluster once you are finished. Find the trashcan next to your [cluster|https://console.cloud.google.com/kubernetes/list].

### Remove the local config of the stopped cluster

Have a look at the clusters and contexts.

```
kubectl config get-clusters

kubectl config get-contexts
```

Find the obsolete contexts and clusters and delete these using a command like:

```
kubectl config delete-context gke_cloud-demo-192820_us-central1-a_cluster-1

kubectl config delete-cluster gke_cloud-demo-192820_us-central1-a_cluster-1
```

