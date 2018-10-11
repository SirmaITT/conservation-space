//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
// Implementation, v2.2.6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.02.27 at 03:46:02 PM EET
//

package com.sirma.itt.seip.definition.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="configuration" type="{}configuration" minOccurs="0"/&gt;
 *         &lt;element name="fields" type="{}complexFieldsDefinition" minOccurs="0"/&gt;
 *         &lt;element name="regions" type="{}regionsDefinition" minOccurs="0"/&gt;
 *         &lt;element name="transitions" type="{}transitionsDefinition" minOccurs="0"/&gt;
 *         &lt;element name="stateTransitions" type="{}stateTransitionsDefinition" minOccurs="0"/&gt;
 *         &lt;element name="allowedChildren" type="{}allowedChildrenType" minOccurs="0"/&gt;
 *         &lt;element ref="{}filterDefinitions" minOccurs="0"/&gt;
 *         &lt;element ref="{}labels" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" use="required" type="{}objectType" /&gt;
 *       &lt;attribute name="id" use="required" type="{}idType" /&gt;
 *       &lt;attribute name="parentId" type="{}idType" /&gt;
 *       &lt;attribute name="referenceId" type="{}idType" /&gt;
 *       &lt;attribute name="purpose" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="isAbstract" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="saveCondition" type="{}expressionType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "configuration", "fields", "regions", "subDefinition", "transitions", "stateTransitions",
		"allowedChildren", "filterDefinitions", "labels" })
@XmlRootElement(name = "definition")
public class Definition {

	protected Configuration configuration;

	/** The fields. */
	protected ComplexFieldsDefinition fields;

	/** The regions. */
	protected RegionsDefinition regions;

	/** The sub definition. */
	protected SubDefinitionType subDefinition;

	/** The transitions. */
	protected TransitionsDefinition transitions;

	/** The state transitions. */
	protected StateTransitionsDefinition stateTransitions;

	/** The allowed children. */
	protected AllowedChildrenType allowedChildren;

	/** The filter definitions. */
	protected FilterDefinitions filterDefinitions;

	/** The labels. */
	protected Labels labels;

	/** The type. */
	@XmlAttribute(name = "type", required = true)
	protected ObjectType type;

	/** The id. */
	@XmlAttribute(name = "id", required = true)
	protected String id;

	/** The parent id. */
	@XmlAttribute(name = "parentId")
	protected String parentId;

	/** The reference id. */
	@XmlAttribute(name = "referenceId")
	protected String referenceId;

	/** The purpose. */
	@XmlAttribute(name = "purpose")
	protected String purpose;

	/** The is abstract. */
	@XmlAttribute(name = "isAbstract")
	protected Boolean isAbstract;

	/** The save condition. */
	@XmlAttribute(name = "saveCondition")
	protected String saveCondition;

	/**
	 * Gets the value of the configuration property.
	 *
	 * @return the configuration possible object is {@link Configuration }
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * Sets the value of the configuration property.
	 *
	 * @param value
	 *            allowed object is {@link Configuration }
	 */
	public void setConfiguration(Configuration value) {
		configuration = value;
	}

	/**
	 * Gets the value of the fields property.
	 *
	 * @return the fields possible object is {@link ComplexFieldsDefinition }
	 */
	public ComplexFieldsDefinition getFields() {
		return fields;
	}

	/**
	 * Sets the value of the fields property.
	 *
	 * @param value
	 *            allowed object is {@link ComplexFieldsDefinition }
	 */
	public void setFields(ComplexFieldsDefinition value) {
		fields = value;
	}

	/**
	 * Gets the value of the regions property.
	 *
	 * @return the regions possible object is {@link RegionsDefinition }
	 */
	public RegionsDefinition getRegions() {
		return regions;
	}

	/**
	 * Sets the value of the regions property.
	 *
	 * @param value
	 *            allowed object is {@link RegionsDefinition }
	 */
	public void setRegions(RegionsDefinition value) {
		regions = value;
	}

	/**
	 * Gets the value of the subDefinition property.
	 *
	 * @return the sub definition possible object is {@link SubDefinitionType }
	 */
	public SubDefinitionType getSubDefinition() {
		return subDefinition;
	}

	/**
	 * Sets the value of the subDefinition property.
	 *
	 * @param value
	 *            allowed object is {@link SubDefinitionType }
	 */
	public void setSubDefinition(SubDefinitionType value) {
		subDefinition = value;
	}

	/**
	 * Gets the value of the transitions property.
	 *
	 * @return the transitions possible object is {@link TransitionsDefinition }
	 */
	public TransitionsDefinition getTransitions() {
		return transitions;
	}

	/**
	 * Sets the value of the transitions property.
	 *
	 * @param value
	 *            allowed object is {@link TransitionsDefinition }
	 */
	public void setTransitions(TransitionsDefinition value) {
		transitions = value;
	}

	/**
	 * Gets the value of the stateTransitions property.
	 *
	 * @return the state transitions possible object is {@link StateTransitionsDefinition }
	 */
	public StateTransitionsDefinition getStateTransitions() {
		return stateTransitions;
	}

	/**
	 * Sets the value of the stateTransitions property.
	 *
	 * @param value
	 *            allowed object is {@link StateTransitionsDefinition }
	 */
	public void setStateTransitions(StateTransitionsDefinition value) {
		stateTransitions = value;
	}

	/**
	 * Gets the value of the allowedChildren property.
	 *
	 * @return the allowed children possible object is {@link AllowedChildrenType }
	 */
	public AllowedChildrenType getAllowedChildren() {
		return allowedChildren;
	}

	/**
	 * Sets the value of the allowedChildren property.
	 *
	 * @param value
	 *            allowed object is {@link AllowedChildrenType }
	 */
	public void setAllowedChildren(AllowedChildrenType value) {
		allowedChildren = value;
	}

	/**
	 * Gets the value of the filterDefinitions property.
	 *
	 * @return the filter definitions possible object is {@link FilterDefinitions }
	 */
	public FilterDefinitions getFilterDefinitions() {
		return filterDefinitions;
	}

	/**
	 * Sets the value of the filterDefinitions property.
	 *
	 * @param value
	 *            allowed object is {@link FilterDefinitions }
	 */
	public void setFilterDefinitions(FilterDefinitions value) {
		filterDefinitions = value;
	}

	/**
	 * Gets the value of the labels property.
	 *
	 * @return the labels possible object is {@link Labels }
	 */
	public Labels getLabels() {
		return labels;
	}

	/**
	 * Sets the value of the labels property.
	 *
	 * @param value
	 *            allowed object is {@link Labels }
	 */
	public void setLabels(Labels value) {
		labels = value;
	}

	/**
	 * Gets the value of the type property.
	 *
	 * @return the type possible object is {@link ObjectType }
	 */
	public ObjectType getType() {
		return type;
	}

	/**
	 * Sets the value of the type property.
	 *
	 * @param value
	 *            allowed object is {@link ObjectType }
	 */
	public void setType(ObjectType value) {
		type = value;
	}

	/**
	 * Gets the value of the id property.
	 *
	 * @return the id possible object is {@link String }
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setId(String value) {
		id = value;
	}

	/**
	 * Gets the value of the parentId property.
	 *
	 * @return the parent id possible object is {@link String }
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * Sets the value of the parentId property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setParentId(String value) {
		parentId = value;
	}

	/**
	 * Gets the value of the referenceId property.
	 *
	 * @return the reference id possible object is {@link String }
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * Sets the value of the referenceId property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setReferenceId(String value) {
		referenceId = value;
	}

	/**
	 * Gets the value of the purpose property.
	 *
	 * @return the purpose possible object is {@link String }
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * Sets the value of the purpose property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setPurpose(String value) {
		purpose = value;
	}

	/**
	 * Gets the value of the isAbstract property.
	 *
	 * @return true, if is checks if is abstract possible object is {@link Boolean }
	 */
	public boolean isIsAbstract() {
		if (isAbstract == null) {
			return false;
		} else {
			return isAbstract;
		}
	}

	/**
	 * Sets the value of the isAbstract property.
	 *
	 * @param value
	 *            allowed object is {@link Boolean }
	 */
	public void setIsAbstract(Boolean value) {
		isAbstract = value;
	}

	/**
	 * Gets the value of the saveCondition property.
	 *
	 * @return the save condition possible object is {@link String }
	 */
	public String getSaveCondition() {
		return saveCondition;
	}

	/**
	 * Sets the value of the saveCondition property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 */
	public void setSaveCondition(String value) {
		saveCondition = value;
	}

}
