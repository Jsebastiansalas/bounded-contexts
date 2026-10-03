# Plataforma de Salud Mental & Teleorientación Asistida por IA

Arquitectura Hexagonal + Domain-Driven Design (DDD) Modular sobre **Spring Boot 3 / Java 17 / PostgreSQL**.

Este repositorio contiene la implementación completa y modular de los **4 Bounded Contexts** derivados de las **52 tablas de base de datos** del sistema, estructurado en **1.092 archivos Java** generados estrictamente bajo el estándar canónico de 21 clases por entidad.

---

## 1. Organización Arquitectónica Multimódulo

El proyecto sigue una separación rigurosa de responsabilidades en cuatro módulos Maven para garantizar el desacoplamiento total del núcleo de negocio frente a frameworks y detalles de infraestructura:

`
tablas 2 - copia/
├── domain/                  # Núcleo puro de negocio (sin dependencias de frameworks)
│   ├── model/               # Entidades, Agregados y Value Objects
│   ├── event/               # Eventos de dominio inmutables
│   ├── exception/           # Excepciones semánticas de negocio
│   └── port/repository/     # Interfaces de puertos de salida (SPI)
├── application/             # Capa de orquestación y casos de uso
│   ├── port/in/             # Puertos de entrada (Casos de uso: Create, Update, Get, Delete)
│   ├── service/             # Servicios de aplicación que coordinan dominio y puertos
│   └── dto/                 # DTOs de respuesta y transferencia limpios
├── infrastructure/          # Adaptadores primarios y secundarios
│   ├── adapter/in/web/      # Controladores REST Spring MVC y DTOs Web Request
│   └── adapter/out/         # Adaptadores de persistencia JPA, Repositorios Spring Data y Entidades
└── demo/                    # Módulo ejecutable y configuración de arranque (Spring Boot Main)
`

---

## 2. Mapa de Bounded Contexts (52 Tablas · 1.092 Archivos)

El sistema agrupa las 52 tablas del modelo relacional en **4 Bounded Contexts** claramente delimitados:

| Bounded Context | Tablas | Archivos | Módulo / Paquete | Descripción |
| :--- | :---: | :---: | :--- | :--- |
| **1. Geography & Reference** | 8 | **168** | com.demodd.*.geography | División territorial jerárquica y catálogos globales de referencia civil y profesional. |
| **2. Patient & Stakeholders** | 8 | **168** | com.demodd.*.patient | Directorio de pacientes, contactos de apoyo, red de emergencia, terapeutas y credenciales. |
| **3. Clinical Care & EHR** | 18 | **378** | com.demodd.*.clinical | Expediente clínico, consultas médicas, notas SOAP, exámenes MSE, riesgo suicida y planes de tratamiento. |
| **4. Chat & Artificial Intelligence**| 18 | **378** | com.demodd.*.chat | Mensajería conversacional, auditoría y telemetría de inferencias LLM, tokens, costes y escalamiento a humanos. |
| **TOTAL** | **52** | **1.092** | | **Cobertura 100% integral de la base de datos relacional** |

---

## 3. Patrón Canónico de 21 Archivos por Entidad

Cada una de las 52 entidades del sistema implementa de forma homogénea las siguientes 21 clases distribuidas en las tres capas hexagonales:

### Capa de Dominio (domain) — 9 archivos
1. model/aggregate/{Entity}.java — Agregado raíz con identidad, estado y métodos de negocio.
2. model/valueobject/{Entity}Id.java — Identificador fuertemente tipado (UUID inmutable).
3. model/valueobject/{Entity}Name.java — Value Object para el atributo semántico principal.
4. model/valueobject/{Entity}Status.java — Value Object para el ciclo de vida de la entidad.
5. event/{Entity}CreatedEvent.java — Evento de dominio emitido al crear la entidad.
6. event/{Entity}UpdatedEvent.java — Evento de dominio emitido al modificar la entidad.
7. exception/{Entity}NotFoundException.java — Excepción lanzada cuando no se localiza el registro.
8. exception/{Entity}AlreadyExistsException.java — Excepción lanzada ante colisión o duplicidad.
9. port/repository/{Entity}RepositoryPort.java — Puerto de salida (contrato para la persistencia).

### Capa de Aplicación (pplication) — 6 archivos
10. port/in/Create{Entity}UseCase.java — Interfaz de caso de uso para creación.
11. port/in/Update{Entity}UseCase.java — Interfaz de caso de uso para actualización.
12. port/in/Get{Entity}UseCase.java — Interfaz de caso de uso para consulta por ID y listado.
13. port/in/Delete{Entity}UseCase.java — Interfaz de caso de uso para eliminación.
14. service/{Entity}ApplicationService.java — Servicio orquestador que implementa los 4 casos de uso.
15. dto/{Entity}Response.java — Objeto inmutable de salida hacia capas superiores.

### Capa de Infraestructura (infrastructure) — 6 archivos
16. dapter/in/web/{Entity}RestController.java — Controlador REST expuesto bajo /api/v1/{entities}.
17. dapter/in/web/dto/Create{Entity}WebRequest.java — DTO de entrada para peticiones POST.
18. dapter/in/web/dto/Update{Entity}WebRequest.java — DTO de entrada para peticiones PUT.
19. dapter/out/persistence/{Entity}JpaEntity.java — Entidad JPA mapeada a la tabla PostgreSQL.
20. dapter/out/persistence/{Entity}SpringDataJpaRepository.java — Repositorio Spring Data JPA con consultas derivadas.
21. dapter/out/persistence/{Entity}RepositoryAdapter.java — Adaptador que implementa el puerto {Entity}RepositoryPort.

---

## 4. Detalle de Entidades por Bounded Context

### Bounded Context 1: Geography & Reference (8 tablas · 168 archivos)
* Country (countries) — Países y códigos telefónicos.
* StateRegion (state_regions) — Departamentos, estados o regiones territoriales.
* CityMunicipality (city_municipalities) — Ciudades y municipios.
* DocumentType (document_types) — Tipos de documento de identidad oficial (CC, CE, TI, Pasaporte).
* Gender (genders) — Género e identidad biológica/social.
* RelationshipType (
elationship_types) — Tipos de parentesco de contactos de apoyo (Padre, Cónyuge, etc.).
* ProfessionalType (professional_types) — Especialidades de salud mental (Psicología, Psiquiatría).
* Study (studies) — Programas académicos y títulos universitarios.

### Bounded Context 2: Patient & Stakeholders (8 tablas · 168 archivos)
* Contact (contacts) — Directorio de contactos y acudientes.
* PhoneContact (phone_contacts) — Números telefónicos asociados a contactos.
* EmailContact (email_contacts) — Correos electrónicos asociados a contactos.
* Professional (professionals) — Especialistas clínicos y número de tarjeta/licencia profesional.
* ProfessionalStudy (professional_studies) — Títulos certificados de cada profesional.
* Patient (patients) — Registro maestro del paciente e información demográfica.
* PatientContact (patient_contacts) — Vinculación entre paciente y su red de contactos de apoyo.
* PatientAllergy (patient_allergies) — Alergias registradas, severidad y reacciones clínicas.

### Bounded Context 3: Clinical Care & EHR (18 tablas · 378 archivos)
* **Catálogos Clínicos (11):**
  * ClinicalRecordStatus (clinical_record_statuses)
  * EncounterType (encounter_types)
  * EncounterModality (encounter_modalities)
  * EncounterStatus (encounter_statuses)
  * RiskLevel (
isk_levels)
  * TreatmentStatus (	reatment_statuses)
  * TreatmentGoalStatus (	reatment_goal_statuses)
  * MedicationRoute (medication_routes)
  * AssessmentType (ssessment_types)
  * ConsentType (consent_types)
  * DiagnosticSystem (diagnostic_systems)
* **Gestión de la Atención Médica (7):**
  * ClinicalRecord (clinical_records) — Historia clínica y expediente del paciente.
  * Encounter (encounters) — Sesiones y encuentros terapéuticos.
  * ClinicalNote (clinical_notes) — Notas clínicas bajo estructura SOAP.
  * MentalStatusExam (mental_status_exams) — Examen del Estado Mental (MSE).
  * RiskAssessment (
isk_assessments) — Evaluación psicométrica y escala de riesgo suicida.
  * TreatmentPlan (	reatment_plans) — Planes de tratamiento activos.
  * TreatmentGoal (	reatment_goals) — Metas terapéuticas SMART.

### Bounded Context 4: Chat & Artificial Intelligence (18 tablas · 378 archivos)
* **Catálogos de Mensajería (6):**
  * Priority (priorities)
  * ConversationStatus (conversations_statuses)
  * SenderType (sender_types)
  * MessageType (message_types)
  * AiRunStatus (i_runs_statuses)
  * EscalationStatus (escalations_statuses)
* **Modelos y Proveedores LLM (2):**
  * ProviderModelAi (provider_models_ai) — Proveedores externos (OpenAI, Anthropic, Google).
  * AiModel (i_models) — Modelos específicos, límites de tokens y costes de inferencia.
* **Canal Conversacional (4):**
  * ChatConversation (chat_conversations) — Canales e hilos de chat.
  * ChatParticipant (chat_participants) — Participantes y roles en el canal.
  * ChatConversationAiSetting (chat_conversation_ai_settings) — Configuración del agente IA por hilo.
  * ChatMessage (chat_messages) — Mensajes y contenido enriquecido en formato JSONB.
* **Telemetría y Auditoría de IA (3):**
  * ChatAiRun (chat_ai_runs) — Ejecución y trazabilidad de inferencias del LLM.
  * ChatAiRunMetric (chat_ai_run_metrics) — Métricas de consumo de tokens y coste en dólares.
  * ChatAiRunError (chat_ai_run_errors) — Registro de excepciones y caídas de API de IA.
* **Escalamiento Asistido (3):**
  * ChatEscalation (chat_escalations) — Tickets de escalamiento a terapeutas humanos.
  * ChatEscalationStatusHistory (chat_escalation_status_history) — Historial y trazabilidad del escalamiento.
  * ChatEscalationAssignment (chat_escalation_assignments) — Asignación efectiva a profesionales de guardia.

---

## 5. Compilación y Verificación

Para compilar todo el árbol de código y comprobar la integridad estricta del proyecto:

`ash
mvn compile -DskipTests
`

Resultado verificado:
`
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for demodd-parent 1.0.0-SNAPSHOT:
[INFO] 
[INFO] demodd-parent ...................................... SUCCESS
[INFO] domain ............................................. SUCCESS
[INFO] application ........................................ SUCCESS
[INFO] infrastructure ..................................... SUCCESS
[INFO] demo ............................................... SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
`

---

## 6. Ejecución del Sistema

1. **Crear la base de datos en PostgreSQL:**
   `sql
   CREATE DATABASE mental_health_db;
   `
2. **Iniciar la aplicación:**
   `ash
   mvn spring-boot:run -pl demo
   `
   Flyway aplicará automáticamente las migraciones V1 a V4 creando las 52 tablas con sus llaves foráneas, índices e integridad referencial.
