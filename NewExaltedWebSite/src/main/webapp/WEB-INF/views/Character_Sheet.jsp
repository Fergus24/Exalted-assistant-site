<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Character_Sheet</title>

<style type="text/css">
  <%@include file="style.css" %>
</style>

</head>
<body>

<%@include file="Header.jsp"%>

	<br><br><br>

	     	<div class = "menuButton">
	    		You currently have ${XP} to spend, would you like to increase your budget? <a href="IncreaseXP1">+1</a>, <a href="IncreaseXP5">+5</a>, <a href="IncreaseXP10">+10</a>.
    		</div>

<!--	     	<div class = "menuButton">
	    		<a href="listCharacters">Return to Character Selection</a>
    		</div>
    -->		
    		<br> <br>
    		<br> <br>
    		<br> <br>
    		${shortage}
    		<br> <br>
    		<br> <br>
    		<br> <br>
    		<div class = "menuButton">
	    		Increasing strength will cost you ${strengthCost}, <br> would you like to <a href="IncreaseStrength">increase strength?</a>
    		</div>
    		

    		
    		
    		<div class = "menuButton">
	    		Increasing dexterity will cost you ${dexterityCost}, would you like to <a href="IncreaseDexterity">increase dexterity?</a>
    		</div>
    		
    		<br> <br>
    		<br> <br>
    		
    		
    		<div class = "menuButton">
	    		Increasing stamina will cost you ${staminaCost}, <br> would you like to <a href="IncreaseStamina">increase stamina?</a>
    		</div>
    		

    		
    		<div class = "menuButton">
	    		Increasing charisma will cost you ${charismaCost}, <br> would you like to <a href="IncreaseCharisma">increase charisma?</a>
    		</div>
    		
    		<br> <br>
    		<br> <br>
    		
    		<div class = "menuButton">
	    		Increasing manipulation will cost you ${manipulationCost}, <br> would you like to <a href="IncreaseManipulation">increase manipulation?</a>
    		</div>
    		

    		
    		<div class = "menuButton">
	    		Increasing appearance will cost you ${appearanceCost}, <br> would you like to <a href="IncreaseAppearance">increase appearance?</a>
    		</div>
    		
    		<br> <br>
    		<br> <br>
    		
    		<div class = "menuButton">
	    		Increasing perception will cost you ${perceptionCost}, <br> would you like to <a href="IncreasePerception">increase perception?</a>
    		</div>
    		

    		
    		<div class = "menuButton">
	    		Increasing intelligence will cost you ${intelligenceCost}, <br> would you like to <a href="IncreaseIntelligence">increase intelligence?</a>
    		</div>  
    		
    		<br> <br>
    		<br> <br>
    		 		
    		<div class = "menuButton">
	    		Increasing your wits will cost you ${witsCost}, <br> would you like to <a href="IncreaseWits">increase wits?</a>
    		</div>
    		
    		<br> <br>
    		<br> <br>

    		<br> <br>
    		<br> <br>
    		
    		    		
    		<div class = "menuButton">
	    		You have spent a total of ${XP_Spent} XP
    		</div>
    		
    		<br> <br>
    		<br> <br>
    		

    		<div class = "menuButton">
    		You own: 
    		<c:forEach items="${ownedCharms}" var="item">
			    		a ${item}, 
			</c:forEach>
			</div>
			
			<br> <br>
    		<br> <br>
			
			
			
			

			
			
			
			
	<sf:form action="BuyCharm">
		<select name = "charmname">
				
				<c:forEach items="${notOwnedCharms}" var="item">
		    			<option> ${item} </option>
				</c:forEach>
				<input type="submit" name="commit" value="BuyCharm" />
				
		</select>
	</sf:form>

 <div id="characterSheet">
            
            <div id="characterSheetHeading" class="characterSheetSection">

                <div id="characterSheetName" class="characterSheetHeadingTraits">
                
                    ${CharacterName}
                
                </div>

 <!--           	<div id="characterSheetMotivation" class="characterSheetHeadingTraits">
                
                    <strong>Motivation:</strong>
                
                </div>

                <div id="characterSheetTypeCasteWrapper" class="characterSheetHeadingTraits">

                    <div id="characterSheetType">
                
                        <strong>Type:</strong>
                
                    </div>

                    <div id="characterSheetCaste">
                
                        <strong>Caste:</strong>
                
                    </div>
                        
                </div>

            </div>
-->
            <div id="attributesHeader" class="characterSheetSectionHeader">
            
                ATTRIBUTES
            
            </div>

            <div id="attributes" class="characterSheetSection">


                <div id="mentalAttributes" class="characterSheetAttributeGroup">
                
                   <div id="traitWrapperPerception" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelPerception" class="characterSheetTraitLabel">
                        
                            Perception
                        
                        </div>

                        <div id="traitDotsPerception" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterPerception}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsPerception}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperIntelligence" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelIntelligence" class="characterSheetTraitLabel">
                        
                            Intelligence
                        
                        </div>

                        <div id="traitDotsIntelligence" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterIntelligence}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsIntelligence}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperWits" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelWits" class="characterSheetTraitLabel">
                        
                            Wits
                        
                        </div>

                        <div id="traitDotsWits" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterWits}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsWits}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>

                
                </div>

                 <div id="socialAttributes" class="characterSheetAttributeGroup">
                
                    <div id="traitWrapperCharisma" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelCharisma" class="characterSheetTraitLabel">
                        
                            Charisma
                        
                        </div>

                        <div id="traitDotsCharisma" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterCharisma}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsCharisma}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperManipulation" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelManipulation" class="characterSheetTraitLabel">
                        
                            Manipulation
                        
                        </div>

                        <div id="traitDotsManipulation" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterManipulation}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsManipulation}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperAppearance" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelAppearance" class="characterSheetTraitLabel">
                        
                            Appearance
                        
                        </div>

                        <div id="traitDotsAppearance" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterAppearance}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsAppearance}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>
                
                </div>

            
                <div id="physicalAttributes" class="characterSheetAttributeGroup">
                
                    <div id="traitWrapperStrength" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelStrength" class="characterSheetTraitLabel">
                        
                            Strength
                        
                        </div>

                        <div id="traitDotsStrength" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterStrength}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsStrength}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
				
                            
                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperDexterity" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelDexterity" class="characterSheetTraitLabel">
                        
                            Dexterity
                        
                        </div>

                        <div id="traitDotsDexterity" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterDexterity}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsDexterity}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                    </div>

                    <div id="traitWrapperStamina" class="characterSheetTraitWrapper">
                    
                        <div id="traitLabelStamina" class="characterSheetTraitLabel">
                        
                            Stamina
                        
                        </div>

                        <div id="traitDotsStamina" class="characterSheetTraitDots">
                        
                            <c:forEach begin="1" end="${CharacterStamina}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotFull.png" id="traitDotPerception1" />
		    				</c:forEach>
				
							<c:forEach begin="1" end="${blankDotsStamina}" varStatus="loop">
                        		<img src="https://mengtzu.github.io/exalted/images/characterSheet/dotEmpty.png" id="traitDotStrength2" />
		    				</c:forEach>
                        
                        </div>
                    
                        
                    </div>

                    <div class="clear"></div>
                
                </div>

            </div>


             </div>
         </div>
        



		<br><br><br><br>

		
<!-- 	<div class = "menuButton">
			<a href="Character_Sheet_XP_Mode">XP Mode</a>
		</div>
-->
</body>
</html>