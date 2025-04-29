https://sdmntprnorthcentralus.oaiusercontent.com/files/00000000-1c8c-622f-af47-12ccee5a697d/raw?se=2025-04-29T10%3A27%3A43Z&sp=r&sv=2024-08-04&sr=b&scid=7c101fa3-f9f6-57db-ac82-b01d50a44877&skoid=de76bc29-7017-43d4-8d90-7a49512bae0f&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2025-04-29T03%3A08%3A31Z&ske=2025-04-30T03%3A08%3A31Z&sks=b&skv=2024-08-04&sig=a/Lybbjpo74q5VRi%2BHzxaBRCfh9r8eYptkkPYS7ZsDY%3D
# 🦊 Compilador Léxico – Java + JFlex + CUP

![Banner](banner.png)

Proyecto académico que demuestra la **construcción de un analizador léxico** (scanner) usando **JFlex** y un analizador sintáctico con **CUP** sobre **Java**, empacado con **Maven**.

---

## 🚀 Stack tecnológico

| Herramienta | Rol |
|-------------|-----|
| **Java 17+** | Lenguaje base del compilador |
| **JFlex** | Generador de analizadores léxicos (`.flex`) |
| **CUP** | Generador de analizadores sintácticos (`.cup`) |
| **Maven** | Gestión de dependencias y build |
| **JUnit 5** | Tests unitarios |

> **Lenguajes del repo:** 65 % Java y 35 % Lex citeturn2view0

---

## 📁 Estructura del proyecto

```
.
├── src
│   └── main
│       └── java
│           ├── jflex
│           │   ├── Lexico.flex    # especificación léxica
│           │   └── Lexico.java    # scanner generado
│           └── ...                # futuras clases del parser
├── pom.xml                         # plugins JFlex & CUP citeturn6view0
└── README.md
```

---

## ⚙️ Cómo compilar

1. **Clonar** el repositorio  
   ```bash
   git clone https://github.com/bobadillaFacundo/compiladorLexico..git
   cd compiladorLexico.
   ```

2. **Generar** scanner + parser y compilar el proyecto  
   ```bash
   mvn clean package
   ```

   - El plugin **`jflex-maven-plugin`** crea `Lexico.java` a partir de `Lexico.flex`.  
   - El plugin **`cup-maven-plugin`** generará las clases del parser.

3. **Ejecutar** pruebas (opcional)  
   ```bash
   mvn test
   ```

---

## 🚀 Ejecución rápida

Si tu clase principal se llama `Main`, podrás correrla así:

```bash
mvn exec:java -Dexec.mainClass="jflex.Main"
```

*(ajusta el nombre del paquete/clase si es distinto).*

---

## ✍️ Contribuir

1. Crea un _fork_   
2. Crea una rama con tu feature: `git checkout -b feat/nueva-funcionalidad`  
3. Haz commit y push: `git push origin feat/nueva-funcionalidad`  
4. Abre un **Pull Request**

---

## 👨‍💻 Autor

**Facundo Bobadilla** — [@bobadillaFacundo](https://github.com/bobadillaFacundo)

¡Las estrellas ⭐ y los PR son bienvenidos!  
