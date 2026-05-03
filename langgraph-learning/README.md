# AI Agent

## What is AI Agent

**QUESTION ------> LLM ------> ANSWER**

When you have LLM and you ask a question, it can give limited answer based on its training cutoff.


Here, if you ask question specific to your organization, it wont be answered because it doesn't have access to the data.


- Now let say if you want to Build a **Chatbot** where you can ask organization related question such as *How many vacation days are there in a year?* and *What is a policy on sick leave ?,etc*.

**Definition**
AI Agent can make decisions and take actions on its own to achieve a goal without being told exactly what to do at every step


> We can build such a system using a RAG architecture

- Let say you have all the Info on the organization data in a PDF file, we can **LLM** to that knowledge using retrieval augmented generation, then you can ask any question and generate the answers.


**RAG is one architecture that gets used to assist LLM with external knowledge.**


## Do we call this agent?
- No, Anthropic defines AI systems which are built using LLM as in two categories:
1. Workflows
2. Agents



## Now if we enhance this chatbot further 

## Agents
- Goal Oriented Planning
- Multi Step Reasoning
- Autonomous Decision Making
- Tool, Knowledge, Memory


Example. 
- Onboard a new Intern joining next Monday.

1. Schedule a Meeting                                            --> Mail/Outlook (LLM)
2. Create intern's profile in HR Management System               --> DB API (LLM)
3. IT Helpdesk (Wi-Fi credentials, Email, Slack access)          --> Wi-Fi, Mail/Outlook, Slack (LLM)
4. Order Laptop, ID Card                                         --> Laptop, ID Card (LLM)

## Chatbot Types

| Type | Reactive | Tool Use | Reasoning | Planning | Proactivity |
| --- | --- | --- | --- | --- | --- |
| RAG Chatbot | ✅ | ❌ | ❌ | ❌ | ❌ |
| Tool Augmented Chatbot | ✅ | ✅ | ❌ | ❌ | ❌ |
| Agentic AI | ✅ | ✅ | ✅ | ✅ | ✅ |

## Reliability

- One of the biggest problems with agents is **reliability**.
- We are providing them some tools and they can do all kinds of crazy things. So we need to control them.

![Check this out](./agents%20reliability%20vs%20control.png)



## What is LangGraph?
- LangGraph helps us build reliable agents
- LangGraph is an expressive, customizable framework designed to build reliable agentic systems. It excels at graph-based, stateful orchestration, allowing for complex loops, retries, and human-in-the-loop control.

**Key Use cases:**
1. Expressive Framework
2. Highly customizable, complex agents
3. LangGraph excels at `Graph-based stateful orchestration`
e.g: Multi-step workflows with memory, streaming and human in the loop control.


**Different frameworks like `LangGraph`**
- Agno
    - Ligtweight & Fast
- Google ADK (Agent Development Kit)
    - Tight GCP, Multi Agent 


| Feature | LangChain | LangGraph |
| --- | --- | --- |
| **Structure** | Linear/Sequential (Chains) | Graph-based (Cycles/Loops) |
| **State** | Stateless or Partially Stateful | Fully Stateful |
| **Control** | Reactive/Predefined	| Autonomous/Independent |
| **Best Use Case**	| Simple Chatbots/RAG | Complex, multi-step workflows (e.g., Vacation planning) | 

## LangChain VS LangGraph

### LangChain 
- Chain Workflow System
![Check this workflow](./langchain%20simple%20chain%20workflow.png)


### LangGraph
- We use langgraph, when we have some kind of autonomy that is given to LLM.
- Stateful Workflows represented as Graphs
![Check this diagram](./langGraph%20autonomous%20system.png)


### Difference

| Feature | LangChain | LangGraph |
| --- | --- | --- | 
| **Purpose** | Toolkit to build LLM apps (chains, tools, agents) | Framework to manage complex workflows with state |
| **Style** | Linear/Reactive chains | Graph-based support loops, retries, memory |
| **Best Use Cases** | Simple Chatbots, RAG Apps, tool usage | Multi-step workflows, agents with memory, conditional paths |

