# What is "system design"?

Usually when you are building a system / engineering system, there is actually  a background behind that,

Real world example: 
#### Scenario : 
*Opening a Restaurant* : **PIZZA PARLOUR**

*Can you scale?*
- if you have 1 chef
- there comes a point though where one chef cannot handle all orders that all the new customers are bringing in.

*So how do you handle more orders*
- if you think like a manager, the first thing you're going to do is ask the chef to work harder
- you can pay them more
- put in more money, they give you more output.


*Now, when you think of `chef` as a computer and put this in technical terms it's called* **Vertical Scaling.**

*Generalization*
You want to optimize processes and increase throughput using the same resources
- preparing before at non-peak hours [`cron jobs`]
    - **reason:** you dont want regular customer to come in and chef is busy making pizza basics.

*How to make Resilient?*
> Resilient : "strong enough to deal with illness, a shock, change, etc."

- chef calls sick one day
- At this point your business is in trouble because there wont be business that day
    - hire backup chef and avoid single points of failure [`master-slave` strategy]


- If business keeps growing everytime, make backup chef *full time*, in fact Hire more `chefs`. [`Horizontal Scaling`]

> Horizontal Scaling : Buying more machines of similar types to get more work done


##### The shop works TIME FOR EXPANSION

*Microservices*
- You have all your responsibilities well defined over here, there is nothing outside your business use cases that you handle,
---

*Distributed System*
- What if there is an **electricity outage** in the pizza shop, you wont have business for a day
- So what you want to do is you want to `distribute`.
- I mean you don't want to put all your eggs in one basket, not not even in one shop. 
- You want to buy a separate shop in a different place which can also deliver pizzas. Maybe it takes more time. Maybe the number of chefs there is lesser but at least you have a backup.
- So we take backup to a different level over here and open a new shop. 
- **In short**: The system must intelligently route orders between shops to optimize delivery, with local shops handling nearby orders for scalability.
---

*Load Balancers*
- Route request in smart way,
- example, a maybe processing time between servers, that is server with better(less delay) efficiency will be `prioritized`.

Now, that system is fault tolerant, scalable, extensible

*Decoupling*
How do we make this system flexible to change?

- Separation of responsibilities, instead of one person (e.g. Manager) managing pizza shop and delivery

System 1
[(Pizza Shop 1) - (Customers) - (Pizza Shop 2) - Load Balancer] \
System 2
[Delivery System]
- such that you can operate system more efficiently.

*Metrics*
- Let's say pizza shop one has a faulty oven, their churning rate goes down. 
- If you have a faulty bike, maybe that particular delivery agent's order times increase. So at this point, what you want is you want to `log` everything. 
- You want to see at what time something happened and what is the next event and so on and so forth. And also you want to be taking those events, condensing them, finding sense out of those events. So that's **`metrics`**.

*Extensible*
- Decouple everything to make your system is extensible.
- You should not need to write code again & again.



### HORIZONTAL vs. VERTICAL SCALING

| HORIZONTAL | VERTICAL |
| --- | --- | 
| Multiple computers (1,2,3,4,...so on) | Huge BOX |
| Load Balancing required | N/A |
| Resilient | Single Point of Failure |
| Network Calls (RPC) | Inter Process Communication |
| Data inconsistency | Data consistent |
| Scales well when users increases | Hardware Limit |
> RPC - Remote Procedure Calls

