# Cybersecurity Plan Lab

## Objective

The cybersecurity plan project aimed to develop a comprehensive security strategy for XYZ Insurance with the NIST Cybersecurity Framework (CSF) as a guiding standard. The primary goal was to enhance the organization’s overall security posture while ensuring compliance with applicable regulations and industry best practices. This project involved assessing current security measures, identifying gaps and risks, and proposing actionable controls to strengthen protection, detection, and response capabilities, providing hands-on experience in strategic cybersecurity planning.

### Skills Learned
- Advanced understanding of the **NIST Cybersecurity Framework (CSF)** and its practical application.  
- Proficiency in **risk assessment** and identifying security gaps in organizational environments.  
- Ability to develop **strategic security controls** to enhance detection, protection, and response.  
- Knowledge of **regulatory compliance requirements** and how to align security measures accordingly.  
- Development of **analytical and problem-solving skills** in cybersecurity planning and policy design.

### Tools Used

- NIST CSF resources for framework guidance and best practices.  
- Microsoft Office Suite (Word, Excel, PowerPoint) for drafting and presenting the cybersecurity plan.  
- Regulatory documentation to ensure compliance with industry standards and organizational policies. 

## Outcome
**XYZ Insurance Cybersecurity Plan**

Table of Contents

[XYZ Insurance Cybersecurity Plan. 3]

[Importance of Cybersecurity. 3]

[Elements of Cybersecurity. 3]

[Impact of Compliance and Governance. 5]

[Applicable Compliances. 6]

[Incorporating Compliance. 6]

[NIST Implementation Strategy. 7]

[NIST Core Functions. 8]

[XYZ Insurance’s Profile. 9]

[Risk Management 10]

[Determining Risk. 10]

[Risk Priorities. 10]

[Qualitative vs. Quantitative Risk Assessments. 11]

[Assessment Strategy. 12]

[ROI vs ROSI 12]

[Risk Matrix. 13]

[Incident Management Plan. 14]

[Post-Incident Lessons Learned. 16]

[Conclusion. 17]

[References. 18]

# XYZ Insurance Cybersecurity Plan

XYZ Insurance includes over 1,200 servers and 1,400 users across two locations that are susceptible to cybersecurity attacks. Therefore, there must be a cybersecurity plan in place with policies, procedures, and tools that should be implemented to improve our security posture. As an insurance company, we handle a large amount of sensitive data that requires proper cybersecurity. This project aims to protect the organization’s assets and data against the constantly evolving cybersecurity threats that companies face today. Through the implementation of NIST protocols, we can ensure compliance, reduced risk, and an overall safe environment that reflects our organization’s goals. This project will allow our company to protect ourselves against threats and to become an insurance company that customers can trust.

# Importance of Cybersecurity

At XYZ Insurance, it is our duty to our clients to keep their information safe in each stage of its lifecycle. Whether its data is moving across our network, being stored in our databases, or being actively used in our system, we are responsible for always protecting it. To do this, we must implement strong cyber security measures that not only protect our clients but also protect the organization from legal implications from applicable regulations. Technology plays a role in every corner of our organization, so prioritizing cybersecurity is of upmost importance. Implementing strong NIST cyber security will allow us to avoid legal repercussions, build customer loyalty and trust, and avoid cyber-attacks that could compromise the business.

Elements of Cybersecurity

Since our company handles sensitive health data, there are several elements that must be incorporated into our cybersecurity framework to protect this data and comply with regulations. Our company must comply with HIPAA, PCI DSS, GLBA, and other state-specific laws that require extensive data protection on customer data. This includes encrypting this sensitive data when in use and when being stored in our databases. Remaining compliant with these laws and regulations not only minimizes attacks on the organization but protects our customers’ sensitive information. To protect our data, we must limit who has access to it by implementing strong authentication and access controls. This includes implementing role-based access controls, so each employee only has access to what is required for their job and using multi-factor authentication. To make sure that we comply with these requirements we must conduct regular compliant audits and improve our cybersecurity posture accordingly.

In tandem with implementing these strong data protection controls, we must be able to detect threats and risks as they appear using incident response tools. There must be a strong incident response plan put in place to identify and resolve threats as they occur in our IT environment. This could include using an SIEM tool like Splunk, an EDR tool like CrowdStrike, IDS/IPS tools, and strong firewalls to protect our network against outside threats. This will allow our organization to detect and resolve both compliance risks and cyber threats before they can progress. If a disastrous cyber event were to occur, our organization needs to have disaster recovery plans that promote business continuity as well. This will ensure that our organization has proper data backups and a plan in place to be able to continue our operations no matter what incident occurs. To help avoid incidents, we must maintain inventories of all hardware, software, services and systems to make sure that no element is unprotected and vulnerable to attacks (NIST, 2021a). Using this inventory, we can check each component for vulnerabilities and update, patch, or retire each as needed.

While technical cybersecurity tools are a huge part of a good cybersecurity posture, the human element is widely overlooked when it comes to putting those tools in use. Non-technical employees must be consistently educated and trained in cybersecurity best practices and hot to detect threats like social engineering attacks. As an organization we have a responsibility to tailor all cybersecurity education and training to each employee’s technical level and job role. By personalizing cybersecurity awareness, we can make it much more understandable and relevant to each user. It is also important that all cybersecurity tools are not too hard to use or create unnecessary burden on employees, so it does not impact their efficiency (NIST, 2021b). The organization should promote cybersecurity best practices in a way that is positive and not fear-eliciting. Cybersecurity can be difficult to communicate and implement so implementing a positive, efficient awareness program can lead to a large decrease in human error and overall attacks.

# Impact of Compliance and Governance

XYZ Insurance must be committed to the privacy and security of its data and systems by complying with all associated regulations. Compliance and governance are of the utmost importance as failure to comply can result in heavy fines, legal action, and the distrust of customers. Thankfully, NIST provides aid to organizations who have compliance regulations but need help with how to achieve that compliance. NIST has various controls that can be implemented by XYZ Insurance to make sure that all technical bases are covered, and data is being properly safeguarded.

## Applicable Compliances

Since XYZ Insurance handles sensitive health and financial information, there are various federal regulations and state specific laws that must meet compliance standards. Since the organization requires customer payment, it must comply to the Gramm-Leach-Bliley Act (GLBA) which states that all customer financial data must be secured. Due to our use of payment processing, compliance with PCI-DSS is imperative to protecting our customer’s cardholder data and transaction information. Along with PCI-DSS, the FTC Safeguards rule also applies and requires that XYZ Insurance implements a comprehensive security program to safeguard customer financial data. Since we are dealing with customer health information, XYZ is also bound to the HIPAA Act and is required to properly protect all Personal Health Information (PHI). The organization is also subject to state laws such as Illinois Personal Information Protection Act (PIPA) and Colorado Data Protection Law (CRS) which requires breach notifications and security measures to protect personal information.

## Incorporating Compliance

Incorporating compliance into our cybersecurity strategy is simple as properly protecting our systems typically leads to meeting compliance requirements. These regulations can be met by utilizing the NIST Cybersecurity Framework (CSF) as mentioned in the cybersecurity strategy. The NIST CSF outlines the Govern function to understand the compliance and security requirements and develop policies to promote them. Next, it includes the Identity function to inventory the sensitive data and systems that is most critical to protect and identify what risks or vulnerabilities that need to be prioritized. It then includes the Protect function which outlines how to protect sensitive information like financial and health data, leading to compliance with GLBA and HIPAA. This function includes training users on how to protect their systems and sensitive data they handle along with access management, software patches, and backup suggestions. The framework then includes the Detect function to monitor all network and systems for threats along with compliance audit controls. It also includes the Respond function to mitigate these threats and vulnerabilities and the Recover function to seek out any improvements that can be made to improve security posture and compliance with regulations (NIST, 2024a).

I would also recommend that XYZ Insurance implements NIST SP 800-53 Rev. 5, a catalog developed by the NIST that includes controls that organizations can use to meet compliance regulations. These controls are designed to aid compliance and risk management requirements and are consistently updated to reflect new regulations and laws. These controls include access controls, awareness and training, audit and accountability, configuration management, etc. This document explains for each of these controls what to do, enhancements they can add for extra protection, why the control is needed, and related controls. It is a great resource for XYZ Insurance to align with regulatory requirements and strengthen their security posture overall. By referencing this catalog, our organization can ensure it is exercising its due diligence for protecting customers and organizational data (Joint Task Force, 2020).

These controls should be reflected in the policies enforced in the organization and regular compliance audits should be carried out to make sure all controls are implemented properly. All users should be trained in compliance and best practices and there should be continuous monitoring to keep track of any changes in regulations and how the organization can improve moving forward.

# NIST Implementation Strategy

NIST CSF 2.0 is a framework that provides guidance to organizations on best practices and controls that can be implemented to manage their cybersecurity risks. XYZ Insurance utilizing this tool will lead to an improved security posture and protection of all organization ad customer data. By implementing CSF’s six core functions, our organization can be sure that every asset is properly secured in the event of a security breach.

## NIST Core Functions

The six CSF core functions are Govern, Identify, Protect, Detect, Respond, and Recover. These core functions are used to organize each sector of an organization’s cybersecurity strategy and implement security at each function. This framework would be extremely beneficial to our organization because it gives us a roadmap to follow to make sure that every layer of our cybersecurity strategy is solid and secure. The first function, Govern, will help XYZ Insurance outline our expectations, create policies to reflect them, and what other functions should be prioritized to meet expectations. The next function is Identify in which all XYZ Insurance’s assets and risks are identified as well as what policies or processes can be improved to support risk management. Once all the risks/assets are identified, the Protect function outlines how to secure those assets to reduce the likelihood and impact of a security event. As an example, say we identify that the customer health database is a top priority asset. We could then protect it using access controls like multi-factor authentication to enter the database or employee awareness on the importance and best practices for keeping the database secure (NIST, 2024b).

As we know, new attacks are consistently emerging so the next function is Detect in which XYZ would be prepared to discover any security breaches. By utilizing this function, XYZ insurance can quickly spot any indicators of compromise (IoC) or anomalies and respond to them in a timely manner. We can use tools like SIEM that collect, correlate, and analyze logs and alert us to any known IoC’s found on our networks. EDR tools can help to monitor staff laptops and servers and can contain, mitigate, and recover from security incidents. Respond is the function in which XYZ Insurance can properly respond to an incident by containing, mitigating, and reporting it. Lastly, the Recover function can help XYZ Insurance with business continuity after a security incident by restoring systems/data back to their original state.

## XYZ Insurance’s Profile

CSF includes organizational profiles that can be used to match XYZ Insurance’s cybersecurity posture and goals with the Core’s guidance. It includes a current profile of XYZ’s current security posture and how much the functions are being achieved and a target profile that the changes will be used to achieve. To create a profile for XYZ, I would first set the scope of the organizational profile to the entire organization and gather information on what policies, resources, risk profiles, practices, roles, etc. that we currently have. I would then create the profile, select the outcomes that we require, and outline our current largest risks. I would include that we handle large quantities of sensitive financial and health data which incur the largest risk implications. Using this information, I would conduct a gap analysis to create an action plan on what changes need to be made to go from the Current profile to our Target profile. These changes would be ongoing so our organization can remain adaptive to new cybersecurity risks and be consistently improving our security posture (NIST, 2024b).

The main goal of implementing the NIST framework is to improve our overall security posture and remain compliant with all regulations. Protecting customer health and financial data is of upmost priority and following this framework can ensure that all aspects of our cybersecurity are properly secured. Having this framework to reference will allow XYZ Insurance to identify what can be improved at each function to ensure comprehensive security. It also provides us a way to track our progress toward our target security posture. Utilizing the NIST CSF, XYZ Insurance can develop an action plan and receive guidance toward accomplishing every cybersecurity goal.

# Risk Management

XYZ Insurance collects and stores thousands of sensitive information like personal data, financial records, etc., which inherently comes with risk. With this risk, risk management becomes crucial for our organization to be proactive about cybersecurity threats before they can make a huge impact. Risk management allows our organization to protect our assets, ensure compliance, minimize loss, and retain customer trust. Through preparation, prevention, and mitigation, we can protect our organization against the evolving cyberthreat landscape.

## Determining Risk

The first step to determine what risks our organization faces is to take the inventory of all assets such as network infrastructure, vendor services, etc. to determine known or potential threats. The next step is to analyze each risk and determine its scope within the organization to see what is affected by the risk. After the risks’ scopes are determined, they should be ranked based on their likelihood and impact if that risk were to occur. The highest likelihood and impact risks should be treated with risk mitigation strategies and controls to minimize their risk score. Lastly, these risk mitigation controls must be continuously monitored to evaluate their effectiveness and increase if needed (Cal Poly Risk Management, n.d.).

## Risk Priorities

There are various types of risks that our organization could face such as reputational damage, cybersecurity risks, operational disruptions, environmental risks, and financial risks. However, I believe the most important risks to be concerned with are cybersecurity risks that could result in ransomware, social engineering, or other types of cyber-attacks. These types of risks can start out as a very small incident like obtaining an employee’s credentials but spread into the entire network and systems being compromised. The escalation of these attacks can result in heavy financial and operational losses along with severe customer distrust and reputational damage. This is why proper cybersecurity measures must be in place such as following the NIST CSF and being proactive with risk management strategies.

Compliance risks should also be of upmost priority because non-compliance can lead to lawsuits, heavy fines, and extreme reputational damage as well. Since our organization collects a large amount of personal customer health and financial information, non-compliance can lead to heavy legal action and even a revoked business license. Thankfully, utilizing the NIST CSF framework, many cybersecurity controls include compliance checking to monitor and mitigate these risks.

## Qualitative vs. Quantitative Risk Assessments

There are different approaches to risk assessments that can be used to know how to correctly prioritize certain risks based on their likelihood and impact. Qualitative risk assessments are more subjective, scenario-based and rely on expert judgements and experience. It acts as more of a general overview that it is easy and fast to apply to any business risks. These assessments are usually paired with quantitative risk assessments which are much more objective, and data driven. The goal of this kind of risk analysis is to translate a risk’s impact and likelihood into a measurable quantity. Since the qualitative technique is more subjective, it is subject to uncertainty in which quantitative can step in and clear up the decision. This approach provides a direct cost/benefit analysis, is objective and therefore neutral, and is grounded in facts which provides a clear picture (Talabis & Martin, 2021).

Through quantitative risk assessments we can get target or estimated single loss expectancy (SLE), annual rate of occurrence (ARO), and annual loss expectancy (ALE). These metrics provide us with the risk value that we can use to determine if a cybersecurity investment is worth mitigating the risk. Both techniques are useful in different scenarios but are the most helpful when paired together. Using this process of risk identification, analysis, and mitigation, we can become proactive about our cyber security goals.

# Assessment Strategy

The best way for XYZ Insurance to decide on whether a cybersecurity project is worth the investment is by using ROI and ROSI assessments. These figures allow us to gain insight into whether a project is going to be worth more than it costs to implement. We can use these strategies to guide our cybersecurity investments and to decide which projects to invest in. This will allow us to remain profitable while introducing new tools to improve our security posture and meet all organizational financial goals moving forward.

## ROI vs ROSI

ROI stands for Return on Investment and this strategy measures how profitable a cybersecurity investment will be. It uses a simple formula including the estimated gain and cost of the investment which in turn gives us profitability. ROI is completely focused on financial profits which is very helpful for other types of investments but is not useful for cybersecurity investments. It does not consider the financial gain from avoided risk which is the primary purpose of cybersecurity projects.

Due to these reasons, ROSI or Return on Security Investment is a much better strategy for evaluating a cybersecurity investment’s return. ROSI is focused on how much the cybersecurity project will benefit the company through avoiding losses caused by cybersecurity incidents. It gives a much more accurate insight into the cost of implementing the cybersecurity tool and the benefits gained from its risk reduction. For example, if we were to implement an SIEM tool like Splunk which collects and analyzes logs to detect potential security threats in real time. This tool costs money and will not directly lead to financial gain but it could lead to identifying and mitigating security threats that could end up costing the company millions. While this tool did not directly make the company money, it could have saved them a substantial amount through risk reduction.

We should use ROSI in our assessment strategy because it includes overlooked factors like risk reduction and annual loss expectancy (ALE) which are imperative to consider when it comes to cybersecurity investments. Using the ROI strategy does not fully encompass the benefits of cybersecurity projects and could lead to an inaccurate cost-benefit analysis. Cybersecurity tools are designed to reduce risk rather than generating revenue so utilizing ROSI in our assessment strategy will allow us to gain a well-rounded understanding of an investment’s worth.

## Risk Matrix

Organizations face countless risks, and it would be a giant financial burden to mitigate them all so there must be a system in place to choose which risks take priority. A risk assessment matrix solves this issue by providing a clear way of prioritizing risks based on its likelihood and impact. Using this matrix, we could prioritize the biggest risks facing our organization and allocate our funds to mitigating them, providing an efficient risk mitigation process. Using this matrix, we can have a consistent way to evaluate the priority of risks and mitigate them accordingly.

I would start by creating a graph with risk likelihood on one axis and risk impact on the other. If a risk is low impact and lo likelihood, it would be in the lower left quadrant while risks with the highest likelihood and probability would be in the top right quadrant. Risks would be given a score of 1 to 8, which 8 being the most impactful and likely risks that need to be mitigated first. Risks 1 to 3 could be risks that are best accepted and it would cost more to mitigate than their impact would cost. To make this more visually comprehendible, I would color code level 1 and 2 risks in green, 3 and 4 in yellow, 5 and 6 in orange, and 7 and 8 in red. This will allow us to follow the color coding and start with mitigating red risks, then orange, and so on and so forth (Irwin, 2023).

Depending on our risk appetite and financial allocation, we can then decide what risk scores we are comfortable with accepting versus which must be mitigated. The risk score would be determined by our cybersecurity professionals and management to allow for both cybersecurity and financial considerations. Cybersecurity professionals can give insight into how impactful a risk would be cybersecurity wise and the damage that could be avoided if mitigated. While management could take into consideration the financial and reputational damage that a risk could incur. This provides an even balance and ensures that the risk mitigation process keeps the organization’s goals in mind while ensuring cybersecurity goals are being met.

# Incident Management Plan

Incident response is an integral part to our organization’s cybersecurity goals because it determines how fast we can detect, contain, and mitigate a threat. The damage an incident can do largely depends on how efficiently we can find and respond to it. This is why it is imperative that we have a solid incident response plan that allows us to respond to incidents in an efficient way. This involves consistently learning from our incident response protocol and improving it along the way to create the most logical process for our organization.

**Incident Preparation and Mitigation**

My recommendation is to utilize NIST SP 800-61r3 which provides us a great outline for how to handle incident response effectively. This protocol includes the life cycle of incident respond which is preparation, incident response, and lessons learned. Before incident response, we must prepare and prevent as many incidents as possible by improving our practices. This phase includes governing which involves establishing expectations and policies that promote our goals. This phase also includes identifying what our cybersecurity risks are and using cybersecurity tools to manage those risks. In the preparation phase, we must ensure we a system in place to prevent as many incidents as possible through policies and cybersecurity tools. This preparation will ensure that we are doing our due diligence to protect our system from incidents and will minimize the impact of incidents if they occur.

During incident response, we must follow the detect, respond, and recover steps to efficiently deal with incidents as they occur. First, we need to be able to properly identify indicators of compromise and analyze the effects of the risk. We should use an SIEM tool, IDS/IPS. EDR, and a network monitoring tool like Wireshark for incident identification and analysis. These tools will allow us to aggregate and analyze logs, network traffic, and endpoints for any indication of a security incident.

From there, we need to respond to the incident by containing and mitigating the incident using tools like SOAR or EDR tools. These tools often include automated incident response which should be utilized but not depended on. We can use these tools to prevent the spread of security breaches and prevent lateral movement through our systems. We can then mitigate the incident and move onto the recovery phase.

Lastly, we need to have a good recovery system in place to ensure all assets and operations affected are restored to ensure business continuity. This includes restoring data from backups, applying patches to affected systems, and using tools like Nessus to ensure all vulnerabilities are mitigated (NIST, 2012). We should take note of all vulnerabilities exploited to carry out the incident and focus our efforts on fixing as many as possible to prevent future exploitation.

## Post-Incident Lessons Learned

Arguably the most imperative part of the incident response is identifying areas of improvement to improve our incident handling process. Using this feedback, we can apply it to our incident response lifecycle and consistently improve our system. These lessons learned should be performed throughout incident response and not just after to ensure best feedback. All lessons are analyzed and prioritized, allowing us to incorporate them into the rest of the lifecycle. For example, if we discover a new threat and see its behavior, we can then adapt our policies and processes to protect ourselves moving forward (NIST, 2012).

During lessons learned meetings, we can identify what occurred, what actions were taken, and how useful those actions were. By doing this, we can identify if there was a better way to handle an incident and identify a more effective solution. This could mean trying out a new cybersecurity tool, changing the process, or implementing a new policy to protect our systems moving forward. This phase is all about growth and directly feeds into every step of the incident response lifecycle, continuing to improve how we respond to security incidents. Cybersecurity threats are constantly emerging and adapting so we must be dedicated to constant improvement which is the main goal of lessons learned.

# Conclusion

By continuously improving using lessons learned, XYZ Insurance can be prepared for cybersecurity threats and can rest assured that our assets and data are protected. It is imperative for our organization to consistently improve and increase our efficiency when it comes to cybersecurity. By implementing lessons learned into our daily work life, we can foster a habit of continuous improvement. Through this practice we can increase efficiency, decrease downtime, and find the cybersecurity protocols and tools that work best for our organization.

Our organization’s cybersecurity future should include constant innovation and improvement of our security posture. The ever-changing cybersecurity threat landscape requires us to be open to change and try new things to find what best suits our goals. By fine-tuning our cybersecurity strategy along the way, we can foster efficiency and safety within our organization. This plan is meant to be adapted and revised to fit our organization as our needs and cybersecurity threats change, leading us closer and closer to a secure environment.

# References

Cal Poly Risk Management. (n.d.). *Risk assessment*. California Polytechnic State University. https://afd.calpoly.edu/risk-management/assessment/

Irwin, L. (2023, May 10). *What is a cyber security risk assessment matrix?* Vigilant Software. https://www.vigilantsoftware.co.uk/blog/what-is-a-cyber-security-risk-assessment-matrix

Joint Task Force. (2020). *Security and privacy controls for information systems and organizations* (NIST Special Publication 800-53 Rev. 5). National Institute of Standards and Technology. https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-53r5.pdf

National Institute of Standards and Technology. (2012). *Computer security incident handling guide* (NIST Special Publication 800-61 Revision 3). https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.800-61r3.pdf

National Institute of Standards and Technology. (2021a). *NIST Special Publication 1299: Guide for the selection of environmental conditions for the storage of data and information* (NIST SP 1299). National Institute of Standards and Technology. https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.1299.pdf

National Institute of Standards and Technology. (2021b). *NIST Special Publication 800-53 Revision 5: Security and privacy controls for information systems and organizations* (NIST SP 800-53 Rev. 5). National Institute of Standards and Technology. https://tsapps.nist.gov/publication/get_pdf.cfm?pub_id=936113

National Institute of Standards and Technology. (2024a). *Cybersecurity framework 2.0* (NIST Special Publication No. 1299). U.S. Department of Commerce. https://nvlpubs.nist.gov/nistpubs/SpecialPublications/NIST.SP.1299.pdf

National Institute of Standards and Technology. (2024b, February 26). *The NIST Cybersecurity Framework (CSF) 2.0* (NIST CSWP 29). https://doi.org/10.6028/NIST.CSWP.29

Talabis, M. R., & Martin, J. (2021). *Risk assessment and analysis methods*. ISACA Journal, 2. https://www.isaca.org/resources/isaca-journal/issues/2021/volume-2/risk-assessment-and-analysis-methods
