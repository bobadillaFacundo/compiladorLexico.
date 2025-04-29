![image](https://github.com/user-attachments/assets/d1b9c8b6-99f2-4ce5-9473-faac355d28a8)



# 🦊 Compilador Léxico – Java + JFlex + CUP


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
