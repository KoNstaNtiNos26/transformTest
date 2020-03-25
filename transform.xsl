<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="1.0">
    <xsl:template match="/">
        <xsl:element name="entries">
            <xsl:for-each select="entries/entry">
            <xsl:element name="entry">
                <xsl:attribute name="field">
                    <xsl:value-of select="./field"/>
                </xsl:attribute>
            </xsl:element>
        </xsl:for-each>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>