


README.md

```bash
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/davicioeu/proyecto-final-T1BO.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin https://github.com/davicioeu/proyecto-final-T1BO.git
git branch -M main
git push -u origin main

```


### Comandos básicos de Git, junto con líneas de código y comentarios explicativos:

**1. Configuración inicial:**

- Configura tu nombre de usuario y dirección de correo electrónico globalmente:
  ```bash
  git config --global user.name "Tu Nombre"
  git config --global user.email "tu@email.com"
  ```

**2. Agregar una cuenta de Git:**

- Configura tu nombre de usuario y dirección de correo electrónico para un repositorio específico:
  ```bash
  git config user.name "Tu Nombre"
  git config user.email "tu@email.com"
  ```
  


**3. Clonar un repositorio:**

- Clona un repositorio remoto a tu máquina local:
  ```bash
  git clone https://github.com/usuario/nombre-repositorio.git
  ```
  
**3.2. Conectarse aun repositorio remoto:**
  ```bash
  git remote add origin https://github.com/davicioeu/proyecto-final-T1BO.git
  ```

**3.3. Renombrar mi rama local:**
 ```bash
 git branch -M main
 ```
 
 
 **3.4. Relacionar la rama local con la rama remota y hacer un merge:**
 ```bash
 git push -u origin main
 git push
 ```


**4. Agregar cambios:**

- Agrega todos los cambios en el directorio de trabajo al área de preparación (staging area):
  ```bash
  git add .
  ```

**5. Confirmar cambios:**

- Confirma los cambios con un mensaje descriptivo:
  ```bash
  git commit -m "Mensaje de commit descriptivo aquí"
  ```

**6. Tirar cambios (Pull):**

- Trae los cambios más recientes desde el repositorio remoto y los fusiona en tu rama actual:
  ```bash
  git pull origin tu-rama
  ```

**7. Empujar cambios (Push):**

- Envía tus cambios confirmados al repositorio remoto:
  ```bash
  git push origin tu-rama
  ```

**8. Cambiar de rama:**

- Cambia a una rama específica:
  ```bash
  git checkout nombre-de-la-rama
  ```

**9. Crear y borrar ramas:**

- Crear una nueva rama:
  ```bash
  git branch nombre-de-la-nueva-rama
  ```

- Cambiar a una nueva rama (y crearla si no existe):
  ```bash
  git checkout -b nombre-de-la-nueva-rama
  ```

- Borrar una rama (asegúrate de no estar en esa rama):
  ```bash
  git branch -d nombre-de-la-rama-a-borrar
  ```

Estos son algunos de los comandos Git básicos que te ayudarán a comenzar a trabajar con Git 
y controlar tus proyectos. Ten en cuenta que Git tiene muchas más funcionalidades y comandos avanzados,
pero estos son esenciales para la mayoría de las tareas cotidianas.