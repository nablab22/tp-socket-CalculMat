# tp-socket-CalculMat
TP2 :« Application client-serveur avec les sockets TCP java pour le calcul matriciel »
L’objectif de ce TP est la construction d’un serveur de calcul matriciel, en utilisant les sockets
TCP de Java.
Plusieurs opérations sur les matrices sont proposées par le serveur.
Le client choisit une opération, envoie l’identifiant de l’opération et ses paramètres, attend la
réponse du serveur puis l’affiche.
Exemples d’opérations : somme de deux matrices, multiplication de deux matrices, transposée
d’une matrice,…
Q1) Ecrire le code du serveur et du client. Lancer le serveur et au moins 2 clients et exécuter le
code. Il est recommandé d’utiliser un serveur multi threads.
Q2) Avant de pouvoir faire appel aux opérations matricielles, chaque client doit s’identifier
auprès du serveur.
Le serveur gère une liste de client, où chaque client est identifié par son nom et son mot de
passe. Si le client n’existe pas au niveau de la liste, le serveur doit l’ajouter. Si le client existe
et que le mot de passe est incorrecte le serveur le signale au client.
