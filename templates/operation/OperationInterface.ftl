/*
 * Generated by operation wizard.
 */

package ${operationPackage};

<#if domainInterface != "">
import ${domainPackage}.${domainInterface};
</#if>
<#if persistenceInterface != "">
import ${persistencePackage}.${persistenceInterface};
</#if>
import org.tentackle.pdo.Operation;

/**
 * ${shortDescription}.
<#if longDescription != "">
 * <p>
 * ${longDescription}
</#if>
 */
<#if domainInterface != "" && persistenceInterface != "">
  <#if abstractOperation == "true">
public interface ${operationInterface}<T extends ${operationInterface}<T>> extends ${superOperationInterface}<T>, ${persistenceInterface}<T>, ${domainInterface}<T> {
  <#else>
public interface ${operationInterface} extends ${superOperationInterface}<${operationInterface}>, ${persistenceInterface}, ${domainInterface} {
  </#if>
<#elseif domainInterface != "">
  <#if abstractOperation == "true">
public interface ${operationInterface}<T extends ${operationInterface}<T>> extends ${superOperationInterface}<T> ${domainInterface}<T> {
  <#else>
public interface ${operationInterface} extends ${superOperationInterface}<${operationInterface}>, ${domainInterface} {
  </#if>
<#elseif persistenceInterface != "">
  <#if abstractOperation == "true">
public interface ${operationInterface}<T extends ${operationInterface}<T>> extends ${superOperationInterface}<T>, ${persistenceInterface}<T> {
  <#else>
public interface ${operationInterface} extends ${superOperationInterface}<${operationInterface}>, ${persistenceInterface} {
  </#if>
<#else>
  <#stop "neither domain- nor persistence-part defined">
</#if>

}